package controladores;


import vista.FrmCitas;
import vista.FrmMenu;

public class MenuController {

    FrmMenu vistaHome;
    FrmCitas vistaCitas;

    public MenuController(FrmMenu vistaHome, FrmCitas vistaCitas) {
        this.vistaHome = vistaHome;
        this.vistaCitas = vistaCitas;
        this.vistaHome.setVisible(true);
        this.cargarFuncionalidades();
    }

    public void cargarFuncionalidades(){
        vistaHome.botonGestionCitas.addActionListener(e -> abrirGestionCitas());
        vistaHome.botonSalir.addActionListener(e -> cerrarPrograma());
    }

    public void abrirGestionCitas(){
        vistaCitas.setVisible(true);
    }

    public void cerrarPrograma(){
        System.exit(0);
    }
}
