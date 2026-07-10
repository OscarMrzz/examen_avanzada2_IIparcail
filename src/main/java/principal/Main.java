package principal;

import javax.swing.UIManager;

import controladores.MenuController;
import vista.FrmCitas;
import vista.FrmMenu;

public class Main {

    public static void main(String[] args) {
   try {
    FrmMenu vistaHome = new FrmMenu();
    FrmCitas vistaCitas = new FrmCitas();
    MenuController controller = new MenuController(vistaHome, vistaCitas);
   } catch (Exception e) {
    e.printStackTrace();
   }
   }
}
