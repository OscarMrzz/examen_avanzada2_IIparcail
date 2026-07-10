package controladores;

import dao.CitaDAOImp;
import dao.CitasDAO;
import dao.DentistasDAO;
import dao.DentistasDAOImp;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.CitaMedica;
import modelo.Dentista;
import vista.FrmCitasEdit;

public class FormularioEditarCitaController {

    FrmCitasEdit vista;
    int idCita;
    CitasController padre;
    CitasDAO citasDAO = new CitaDAOImp();
    DentistasDAO dentistasDAO = new DentistasDAOImp();

    public FormularioEditarCitaController(FrmCitasEdit vista, int idCita, CitasController padre) {
        this.vista = vista;
        this.idCita = idCita;
        this.padre = padre;
        this.cargarDentistasEnCombo();
        this.cargarCitaEnFormulario();
        this.cargarFuncionalidades();
        this.configurarCalculoTotal();
        this.vista.setVisible(true);
    }

    public void cargarFuncionalidades() {
        this.vista.botonActualizar.addActionListener(e -> actualizarCita());
        this.vista.botonCancelar.addActionListener(e -> cancelar());
    }

    public void cargarDentistasEnCombo() {
        vista.comboDentistas.removeAllItems();
        try {
            for (Dentista dentista : dentistasDAO.getAll()) {
                if ("ACTIVO".equalsIgnoreCase(dentista.getEstado())) {
                    vista.comboDentistas.addItem(dentista);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al cargar dentistas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarCitaEnFormulario() {
        CitaMedica cita = citasDAO.getById(idCita);

        if (cita.getIdCita() == 0) {
            JOptionPane.showMessageDialog(vista, "No se encontro la cita seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            vista.dispose();
            return;
        }

        vista.inputPaciente.setText(cita.getPaciente());
        vista.inputMontoProcedimiento.setText(String.valueOf(cita.getMontoProcedimiento()));
        vista.inputMontoMateriales.setText(String.valueOf(cita.getMontoMateriales()));
        vista.inputTotalNeto.setText(String.valueOf(cita.getTotalNeto()));

        for (int i = 0; i < vista.comboDentistas.getItemCount(); i++) {
            Dentista dentista = vista.comboDentistas.getItemAt(i);
            if (dentista.getIdDentista() == cita.getIdDentista()) {
                vista.comboDentistas.setSelectedIndex(i);
                break;
            }
        }
    }

    public void actualizarCita() {
        Dentista dentista = (Dentista) vista.comboDentistas.getSelectedItem();
        if (dentista == null) {
            JOptionPane.showMessageDialog(vista, "Seleccione un dentista.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String paciente = vista.inputPaciente.getText().trim();
        if (paciente.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el nombre del paciente.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double montoProcedimiento;
        double montoMateriales;
        try {
            montoProcedimiento = Double.parseDouble(vista.inputMontoProcedimiento.getText().trim());
            montoMateriales = Double.parseDouble(vista.inputMontoMateriales.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Los montos deben ser valores numericos.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (montoProcedimiento < 0 || montoMateriales < 0) {
            JOptionPane.showMessageDialog(vista, "Los montos no pueden ser negativos.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double totalNeto = montoProcedimiento + montoMateriales;
        CitaMedica cita = new CitaMedica(
                idCita,
                dentista.getIdDentista(),
                paciente,
                null,
                montoProcedimiento,
                montoMateriales,
                totalNeto
        );

        if (citasDAO.update(cita)) {
            JOptionPane.showMessageDialog(vista, "Cita actualizada correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            padre.cargarDatosEnTabla();
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo actualizar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelar() {
        vista.dispose();
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

        vista.inputMontoProcedimiento.getDocument().addDocumentListener(listener);
        vista.inputMontoMateriales.getDocument().addDocumentListener(listener);
    }

    private void calcularTotalNeto() {
        try {
            double procedimiento = vista.inputMontoProcedimiento.getText().trim().isEmpty()
                    ? 0
                    : Double.parseDouble(vista.inputMontoProcedimiento.getText().trim());
            double materiales = vista.inputMontoMateriales.getText().trim().isEmpty()
                    ? 0
                    : Double.parseDouble(vista.inputMontoMateriales.getText().trim());
            vista.inputTotalNeto.setText(String.valueOf(procedimiento + materiales));
        } catch (NumberFormatException e) {
            vista.inputTotalNeto.setText("");
        }
    }
}
