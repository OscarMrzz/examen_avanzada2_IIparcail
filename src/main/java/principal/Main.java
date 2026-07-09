package principal;

import javax.swing.UIManager;
import vista.FrmMenu;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }

        java.awt.EventQueue.invokeLater(() -> new FrmMenu().setVisible(true));
    }
}
