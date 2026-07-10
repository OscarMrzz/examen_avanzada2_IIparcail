package vista;

public class FrmCitas extends javax.swing.JFrame {

    public FrmCitas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDentista = new javax.swing.JLabel();
        comboDentistas = new javax.swing.JComboBox<>();
        lblPaciente = new javax.swing.JLabel();
        inputPaciente = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        try {
            javax.swing.text.MaskFormatter mascaraFecha = new javax.swing.text.MaskFormatter("##/##/####");
            mascaraFecha.setPlaceholderCharacter('_');
            inputFecha = new javax.swing.JFormattedTextField(mascaraFecha);
        } catch (java.text.ParseException ex) {
            inputFecha = new javax.swing.JFormattedTextField();
        }
        lblHora = new javax.swing.JLabel();
        try {
            javax.swing.text.MaskFormatter mascaraHora = new javax.swing.text.MaskFormatter("##:##");
            mascaraHora.setPlaceholderCharacter('_');
            inputHora = new javax.swing.JFormattedTextField(mascaraHora);
        } catch (java.text.ParseException ex) {
            inputHora = new javax.swing.JFormattedTextField();
        }
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
        botonRefrescar = new javax.swing.JButton();
        botonAbrirActualizar = new javax.swing.JButton();
        botonElimininar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DentaSmart - Registro de Citas Medicas");

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 150, 136));
        lblTitulo.setText("Registro de Citas Medicas");

        lblDentista.setText("Dentista:");

        lblPaciente.setText("Paciente:");

        lblFecha.setText("Fecha:");

        inputFecha.setToolTipText("Formato dd/MM/yyyy (ejemplo 09/07/2026)");

        lblHora.setText("Hora:");

        inputHora.setToolTipText("Formato HH:mm (ejemplo 14:30)");

        lblMontoProcedimiento.setText("Monto Procedimiento (L):");

        lblMontoMateriales.setText("Monto Materiales (L):");

        lblTotalNeto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTotalNeto.setText("Total Neto (L):");

        inputTotalNeto.setEditable(false);

        botonProcesarCita.setBackground(new java.awt.Color(38, 166, 154));
        botonProcesarCita.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botonProcesarCita.setForeground(new java.awt.Color(255, 255, 255));
        botonProcesarCita.setText("Procesar Cita");

        botonLimpiar.setBackground(new java.awt.Color(120, 144, 156));
        botonLimpiar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        botonLimpiar.setText("Limpiar");

        lblHistorial.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
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
        botonImprimirComprobante.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botonImprimirComprobante.setForeground(new java.awt.Color(255, 255, 255));
        botonImprimirComprobante.setText("Imprimir Comprobante");

        botonRefrescar.setText("Refrescar");

        botonAbrirActualizar.setText("Actualizar");

        botonElimininar.setText("Eliminar");

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
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDentistas, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMontoProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMontoMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonProcesarCita)
                        .addGap(41, 41, 41)
                        .addComponent(botonLimpiar)
                        .addGap(27, 27, 27)
                        .addComponent(botonRefrescar)
                        .addGap(18, 18, 18)
                        .addComponent(botonAbrirActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonElimininar)))
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
                    .addComponent(lblFecha)
                    .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(botonLimpiar)
                    .addComponent(botonRefrescar)
                    .addComponent(botonAbrirActualizar)
                    .addComponent(botonElimininar))
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
    public javax.swing.JButton botonAbrirActualizar;
    public javax.swing.JButton botonElimininar;
    public javax.swing.JButton botonImprimirComprobante;
    public javax.swing.JButton botonLimpiar;
    public javax.swing.JButton botonProcesarCita;
    public javax.swing.JButton botonRefrescar;
    public javax.swing.JComboBox<modelo.Dentista> comboDentistas;
    public javax.swing.JFormattedTextField inputFecha;
    public javax.swing.JFormattedTextField inputHora;
    public javax.swing.JTextField inputMontoMateriales;
    public javax.swing.JTextField inputMontoProcedimiento;
    public javax.swing.JTextField inputPaciente;
    public javax.swing.JTextField inputTotalNeto;
    public javax.swing.JLabel lblDentista;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHistorial;
    public javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblMontoMateriales;
    public javax.swing.JLabel lblMontoProcedimiento;
    public javax.swing.JLabel lblPaciente;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblTotalNeto;
    public javax.swing.JScrollPane scrollHistorial;
    public javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
