package principal;

import controladores.CitasController;
import controladores.MenuController;
import vista.FrmCitas;
import vista.FrmMenu;

public class Main {

    public static void main(String[] args) {
   try {
    FrmMenu vistaHome = new FrmMenu();
    FrmCitas vistaCitas = new FrmCitas();
    MenuController menuController = new MenuController(vistaHome, vistaCitas);
    CitasController citasController = new CitasController(vistaCitas, vistaHome);
   } catch (Exception e) {
    e.printStackTrace();
   }
   }
}
