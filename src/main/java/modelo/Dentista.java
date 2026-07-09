package modelo;

public class Dentista {

    private int idDentista;
    private String nombre;
    private String apellido;
    private String especialidad;
    private double salarioBase;
    private String estado;

    public Dentista() {
    }

    public Dentista(int idDentista, String nombre, String apellido,
                    String especialidad, double salarioBase, String estado) {
        this.idDentista = idDentista;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.salarioBase = salarioBase;
        this.estado = estado;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + especialidad;
    }
}
