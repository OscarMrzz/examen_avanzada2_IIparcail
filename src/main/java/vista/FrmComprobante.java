package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrmComprobante extends JDialog {

  private static final Color COLOR_TITULO = new Color(0, 150, 136);
  private static final Color COLOR_BOTON = new Color(38, 166, 154);
  private static final Color COLOR_ETIQUETA = new Color(120, 144, 156);
  private static final Color COLOR_VALOR = new Color(55, 71, 79);
  private static final Color COLOR_TOTAL = new Color(0, 150, 136);

  public FrmComprobante(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    setLocationRelativeTo(parent);
  }

  private void initComponents() {
    setTitle("DentaSmart - Comprobante");
    getContentPane().setBackground(Color.WHITE);
    setResizable(false);

    JPanel panelContenido = new JPanel();
    panelContenido.setBackground(Color.WHITE);
    panelContenido.setBorder(BorderFactory.createEmptyBorder(24, 32, 24, 32));
    panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

    lblTitulo = new JLabel("Comprobante");
    lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
    lblTitulo.setForeground(COLOR_TITULO);
    lblTitulo.setAlignmentX(LEFT_ALIGNMENT);

    lblSubtitulo = new JLabel("DentaSmart - Clinica Odontologica");
    lblSubtitulo.setFont(new Font("SansSerif", Font.PLAIN, 12));
    lblSubtitulo.setForeground(COLOR_ETIQUETA);
    lblSubtitulo.setAlignmentX(LEFT_ALIGNMENT);

    valorId = crearValor();
    valorDentista = crearValor();
    valorEspecialidad = crearValor();
    valorPaciente = crearValor();
    valorFecha = crearValor();
    valorProcedimiento = crearValor();
    valorMateriales = crearValor();
    valorTotalNeto = new JLabel(" ");
    valorTotalNeto.setFont(new Font("SansSerif", Font.BOLD, 16));
    valorTotalNeto.setForeground(COLOR_TOTAL);
    valorTotalNeto.setPreferredSize(new Dimension(220, 20));

    botonCerrar = new JButton("Cerrar");
    botonCerrar.setBackground(COLOR_BOTON);
    botonCerrar.setFont(new Font("SansSerif", Font.BOLD, 14));
    botonCerrar.setForeground(Color.WHITE);
    botonCerrar.setFocusPainted(false);
    botonCerrar.setBorderPainted(false);

    panelContenido.add(lblTitulo);
    panelContenido.add(Box.createVerticalStrut(4));
    panelContenido.add(lblSubtitulo);
    panelContenido.add(Box.createVerticalStrut(20));
    panelContenido.add(crearFila("ID Cita", valorId));
    panelContenido.add(crearFila("Dentista", valorDentista));
    panelContenido.add(crearFila("Especialidad", valorEspecialidad));
    panelContenido.add(crearFila("Paciente", valorPaciente));
    panelContenido.add(crearFila("Fecha", valorFecha));
    panelContenido.add(crearFila("Procedimiento (L)", valorProcedimiento));
    panelContenido.add(crearFila("Materiales (L)", valorMateriales));
    panelContenido.add(Box.createVerticalStrut(8));
    panelContenido.add(crearFilaTotal("Total Neto (L)", valorTotalNeto));
    panelContenido.add(Box.createVerticalStrut(24));

    JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    panelBoton.setBackground(Color.WHITE);
    panelBoton.setAlignmentX(LEFT_ALIGNMENT);
    panelBoton.add(botonCerrar);
    panelContenido.add(panelBoton);

    getContentPane().add(panelContenido, BorderLayout.CENTER);
  }

  public void actualizarVista() {
    pack();
    revalidate();
    repaint();
  }

  private JPanel crearFila(String textoEtiqueta, JLabel valor) {
    JPanel fila = new JPanel(new BorderLayout(16, 0));
    fila.setBackground(Color.WHITE);
    fila.setAlignmentX(LEFT_ALIGNMENT);
    fila.setMaximumSize(new Dimension(420, 32));

    JLabel etiqueta = crearEtiqueta(textoEtiqueta);
    etiqueta.setPreferredSize(new Dimension(150, etiqueta.getPreferredSize().height));

    fila.add(etiqueta, BorderLayout.WEST);
    fila.add(valor, BorderLayout.CENTER);
    return fila;
  }

  private JPanel crearFilaTotal(String textoEtiqueta, JLabel valor) {
    JPanel fila = new JPanel(new BorderLayout(16, 0));
    fila.setBackground(Color.WHITE);
    fila.setAlignmentX(LEFT_ALIGNMENT);
    fila.setMaximumSize(new Dimension(420, 32));

    JLabel etiqueta = new JLabel(textoEtiqueta);
    etiqueta.setFont(new Font("SansSerif", Font.BOLD, 13));
    etiqueta.setForeground(COLOR_TOTAL);
    etiqueta.setPreferredSize(new Dimension(150, etiqueta.getPreferredSize().height));

    fila.add(etiqueta, BorderLayout.WEST);
    fila.add(valor, BorderLayout.CENTER);
    return fila;
  }

  private JLabel crearEtiqueta(String texto) {
    JLabel etiqueta = new JLabel(texto);
    etiqueta.setFont(new Font("SansSerif", Font.PLAIN, 13));
    etiqueta.setForeground(COLOR_ETIQUETA);
    return etiqueta;
  }

  private JLabel crearValor() {
    JLabel valor = new JLabel(" ");
    valor.setFont(new Font("SansSerif", Font.PLAIN, 14));
    valor.setForeground(COLOR_VALOR);
    valor.setPreferredSize(new Dimension(220, 20));
    return valor;
  }

  public JLabel lblTitulo;
  public JLabel lblSubtitulo;
  public JLabel valorId;
  public JLabel valorDentista;
  public JLabel valorEspecialidad;
  public JLabel valorPaciente;
  public JLabel valorFecha;
  public JLabel valorProcedimiento;
  public JLabel valorMateriales;
  public JLabel valorTotalNeto;
  public JButton botonCerrar;
}
