package vista;

public class FrmMenu extends javax.swing.JFrame {

    public FrmMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        botonGestionCitas = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        lblPie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DentaSmart - Menu Principal");

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 28));
        lblTitulo.setForeground(new java.awt.Color(0, 150, 136));
        lblTitulo.setText("DentaSmart");

        lblSubtitulo.setFont(new java.awt.Font("SansSerif", 0, 15));
        lblSubtitulo.setText("Clinica Odontologica - Menu Principal");

        botonGestionCitas.setBackground(new java.awt.Color(38, 166, 154));
        botonGestionCitas.setFont(new java.awt.Font("SansSerif", 1, 16));
        botonGestionCitas.setForeground(new java.awt.Color(255, 255, 255));
        botonGestionCitas.setText("Gestionar Citas");
        botonGestionCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionCitasActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(120, 144, 156));
        botonSalir.setFont(new java.awt.Font("SansSerif", 1, 16));
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        lblPie.setFont(new java.awt.Font("SansSerif", 0, 12));
        lblPie.setText("DentaSmart 2026");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblSubtitulo)
                    .addComponent(lblPie)
                    .addComponent(botonGestionCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo)
                .addGap(30, 30, 30)
                .addComponent(botonGestionCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblPie)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGestionCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionCitasActionPerformed
    }//GEN-LAST:event_botonGestionCitasActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
    }//GEN-LAST:event_botonSalirActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonGestionCitas;
    public javax.swing.JButton botonSalir;
    public javax.swing.JLabel lblPie;
    public javax.swing.JLabel lblSubtitulo;
    public javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
