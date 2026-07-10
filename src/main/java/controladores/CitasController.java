package controladores;

import dao.CitaDAOImp;
import dao.CitasDAO;
import dao.DentistasDAO;
import dao.DentistasDAOImp;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import modelo.CitaMedica;
import modelo.Dentista;
import vista.FrmCitas;
import vista.FrmCitasEdit;
import vista.FrmMenu;

public class CitasController {

    FrmCitas vistaCitas;
    FrmMenu vistaHome;
    CitasDAO citasDAO = new CitaDAOImp();
    DentistasDAO dentistasDAO = new DentistasDAOImp();

    public CitasController(FrmCitas vistaCitas, FrmMenu vistaHome) {
        this.vistaCitas = vistaCitas;
        this.vistaHome = vistaHome;
        this.cargarFuncionalidades();
    }

    public void cargarFuncionalidades() {
        this.vistaCitas.botonProcesarCita.addActionListener(e -> procesarCita());
        this.vistaCitas.botonLimpiar.addActionListener(e -> limpiarCampos());
        this.vistaCitas.botonRefrescar.addActionListener(e -> cargarDatosEnTabla());
        this.vistaCitas.botonAbrirActualizar.addActionListener(e -> abrirFormularioEditar());
        this.vistaCitas.botonElimininar.addActionListener(e -> eliminarCita());
        this.vistaCitas.botonImprimirComprobante.addActionListener(e -> imprimirComprobante());
        this.cargarDentistasEnCombo();
        this.cargarDatosEnTabla();
        this.configurarCalculoTotal();
    }

    public void procesarCita() {
        Dentista dentista = (Dentista) vistaCitas.comboDentistas.getSelectedItem();
        if (dentista == null) {
            JOptionPane.showMessageDialog(vistaCitas, "Seleccione un dentista.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String paciente = vistaCitas.inputPaciente.getText().trim();
        if (paciente.isEmpty()) {
            JOptionPane.showMessageDialog(vistaCitas, "Ingrese el nombre del paciente.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double montoProcedimiento;
        double montoMateriales;
        try {
            montoProcedimiento = Double.parseDouble(vistaCitas.inputMontoProcedimiento.getText().trim());
            montoMateriales = Double.parseDouble(vistaCitas.inputMontoMateriales.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vistaCitas, "Los montos deben ser valores numericos.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (montoProcedimiento < 0 || montoMateriales < 0) {
            JOptionPane.showMessageDialog(vistaCitas, "Los montos no pueden ser negativos.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double totalNeto = montoProcedimiento + montoMateriales;
        CitaMedica cita = new CitaMedica(dentista.getIdDentista(), paciente, montoProcedimiento, montoMateriales, totalNeto);

        if (citasDAO.create(cita)) {
            JOptionPane.showMessageDialog(vistaCitas, "Cita registrada correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosEnTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaCitas, "No se pudo registrar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarCampos() {
        vistaCitas.inputPaciente.setText("");
        vistaCitas.inputMontoProcedimiento.setText("");
        vistaCitas.inputMontoMateriales.setText("");
        vistaCitas.inputTotalNeto.setText("");
        if (vistaCitas.comboDentistas.getItemCount() > 0) {
            vistaCitas.comboDentistas.setSelectedIndex(0);
        }
        vistaCitas.inputPaciente.requestFocus();
    }

    public void cargarDentistasEnCombo() {
        vistaCitas.comboDentistas.removeAllItems();
        try {
            for (Dentista dentista : dentistasDAO.getAll()) {
                if ("ACTIVO".equalsIgnoreCase(dentista.getEstado())) {
                    vistaCitas.comboDentistas.addItem(dentista);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaCitas, "Error al cargar dentistas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarDatosEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vistaCitas.tablaHistorial.getModel();
        modelo.setRowCount(0);

        try {
            for (CitaMedica cita : citasDAO.getAll()) {
                Dentista dentista = dentistasDAO.getById(cita.getIdDentista());
                String nombreDentista = dentista.getNombre() + " " + dentista.getApellido();
                modelo.addRow(new Object[]{
                    cita.getIdCita(),
                    nombreDentista,
                    dentista.getEspecialidad(),
                    cita.getPaciente(),
                    cita.getFechaCita(),
                    cita.getMontoProcedimiento(),
                    cita.getMontoMateriales(),
                    cita.getTotalNeto()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vistaCitas, "Error al cargar el historial de citas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarCita() {
        int fila = vistaCitas.tablaHistorial.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(vistaCitas, "Seleccione una cita de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                vistaCitas,
                "¿Desea eliminar la cita seleccionada?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) vistaCitas.tablaHistorial.getModel();
        int idCita = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

        if (citasDAO.delete(idCita)) {
            JOptionPane.showMessageDialog(vistaCitas, "Cita eliminada correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosEnTabla();
        } else {
            JOptionPane.showMessageDialog(vistaCitas, "No se pudo eliminar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void abrirFormularioEditar() {
        int fila = vistaCitas.tablaHistorial.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(vistaCitas, "Seleccione una cita de la tabla para actualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) vistaCitas.tablaHistorial.getModel();
        int idCita = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

        FrmCitasEdit vistaEdit = new FrmCitasEdit();
        new FormularioEditarCitaController(vistaEdit, idCita, this);
    }

    public void imprimirComprobante() {
    }

    private void configurarCalculoTotal() {
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                calcularTotalNeto();
            }

            public void removeUpdate(DocumentEvent e) {
                calcularTotalNeto();
            }

            public void changedUpdate(DocumentEvent e) {
                calcularTotalNeto();
            }
        };

        vistaCitas.inputMontoProcedimiento.getDocument().addDocumentListener(listener);
        vistaCitas.inputMontoMateriales.getDocument().addDocumentListener(listener);
    }

    private void calcularTotalNeto() {
        try {
            double procedimiento = vistaCitas.inputMontoProcedimiento.getText().trim().isEmpty()
                    ? 0
                    : Double.parseDouble(vistaCitas.inputMontoProcedimiento.getText().trim());
            double materiales = vistaCitas.inputMontoMateriales.getText().trim().isEmpty()
                    ? 0
                    : Double.parseDouble(vistaCitas.inputMontoMateriales.getText().trim());
            vistaCitas.inputTotalNeto.setText(String.valueOf(procedimiento + materiales));
        } catch (NumberFormatException e) {
            vistaCitas.inputTotalNeto.setText("");
        }
    }
}
