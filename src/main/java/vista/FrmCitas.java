package vista;

import modelo.Dentista;

public class FrmCitas extends javax.swing.JFrame {

    public FrmCitas() {
        initComponents();
        cargarDatosDeEjemplo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDentista = new javax.swing.JLabel();
        comboDentistas = new javax.swing.JComboBox<>();
        lblPaciente = new javax.swing.JLabel();
        inputPaciente = new javax.swing.JTextField();
        lblMontoProcedimiento = new javax.swing.JLabel();
        inputMontoProcedimiento = new javax.swing.JTextField();
        lblMontoMateriales = new javax.swing.JLabel();
        inputMontoMateriales = new javax.swing.JTextField();
        lblTotalNeto = new javax.swing.JLabel();
        inputTotalNeto = new javax.swing.JTextField();
        botonProcesarCita = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        lblHistorial = new javax.swing.JLabel();
        scrollHistorial = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        botonImprimirComprobante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DentaSmart - Registro de Citas Medicas");

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblTitulo.setForeground(new java.awt.Color(0, 150, 136));
        lblTitulo.setText("Registro de Citas Medicas");

        lblDentista.setText("Dentista:");

        lblPaciente.setText("Paciente:");

        lblMontoProcedimiento.setText("Monto Procedimiento (L):");

        lblMontoMateriales.setText("Monto Materiales (L):");

        lblTotalNeto.setFont(new java.awt.Font("SansSerif", 1, 14));
        lblTotalNeto.setText("Total Neto (L):");

        inputTotalNeto.setEditable(false);

        botonProcesarCita.setBackground(new java.awt.Color(38, 166, 154));
        botonProcesarCita.setFont(new java.awt.Font("SansSerif", 1, 14));
        botonProcesarCita.setForeground(new java.awt.Color(255, 255, 255));
        botonProcesarCita.setText("Procesar Cita");
        botonProcesarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProcesarCitaActionPerformed(evt);
            }
        });

        botonLimpiar.setBackground(new java.awt.Color(120, 144, 156));
        botonLimpiar.setFont(new java.awt.Font("SansSerif", 1, 14));
        botonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        lblHistorial.setFont(new java.awt.Font("SansSerif", 1, 16));
        lblHistorial.setText("Historial de Citas");

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Dentista", "Especialidad", "Paciente", "Fecha", "Procedimiento", "Materiales", "Total Neto"
            }
        ));
        scrollHistorial.setViewportView(tablaHistorial);

        botonImprimirComprobante.setBackground(new java.awt.Color(38, 166, 154));
        botonImprimirComprobante.setFont(new java.awt.Font("SansSerif", 1, 14));
        botonImprimirComprobante.setForeground(new java.awt.Color(255, 255, 255));
        botonImprimirComprobante.setText("Imprimir Comprobante");
        botonImprimirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirComprobanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(scrollHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHistorial)
                    .addComponent(botonImprimirComprobante)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonProcesarCita))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDentistas, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMontoProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMontoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonLimpiar))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDentista)
                    .addComponent(comboDentistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(inputPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoProcedimiento)
                    .addComponent(inputMontoProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoMateriales)
                    .addComponent(inputMontoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalNeto)
                    .addComponent(inputTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonProcesarCita)
                    .addComponent(botonLimpiar))
                .addGap(30, 30, 30)
                .addComponent(lblHistorial)
                .addGap(10, 10, 10)
                .addComponent(scrollHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonImprimirComprobante)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonProcesarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProcesarCitaActionPerformed
    }//GEN-LAST:event_botonProcesarCitaActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        inputPaciente.setText("");
        inputMontoProcedimiento.setText("");
        inputMontoMateriales.setText("");
        inputTotalNeto.setText("");
        inputPaciente.requestFocus();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonImprimirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirComprobanteActionPerformed
    }//GEN-LAST:event_botonImprimirComprobanteActionPerformed

    private void cargarDatosDeEjemplo() {
        comboDentistas.addItem(new Dentista(1, "Ana", "Lopez", "Ortodoncia", 18000, "ACTIVO"));
        comboDentistas.addItem(new Dentista(2, "Carlos", "Meza", "Endodoncia", 20000, "ACTIVO"));

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaHistorial.getModel();
        modelo.addRow(new Object[]{1, "Ana Lopez", "Ortodoncia", "Juan Perez", "2026-07-08", "1500.00", "500.00", "2000.00"});
        modelo.addRow(new Object[]{2, "Carlos Meza", "Endodoncia", "Maria Diaz", "2026-07-08", "2200.00", "800.00", "3000.00"});
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonImprimirComprobante;
    public javax.swing.JButton botonLimpiar;
    public javax.swing.JButton botonProcesarCita;
    public javax.swing.JComboBox<modelo.Dentista> comboDentistas;
    public javax.swing.JTextField inputMontoMateriales;
    public javax.swing.JTextField inputMontoProcedimiento;
    public javax.swing.JTextField inputPaciente;
    public javax.swing.JTextField inputTotalNeto;
    public javax.swing.JLabel lblDentista;
    public javax.swing.JLabel lblHistorial;
    public javax.swing.JLabel lblMontoMateriales;
    public javax.swing.JLabel lblMontoProcedimiento;
    public javax.swing.JLabel lblPaciente;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblTotalNeto;
    public javax.swing.JScrollPane scrollHistorial;
    public javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
