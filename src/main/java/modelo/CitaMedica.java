package modelo;

public class CitaMedica {

    private int idCita;
    private int idDentista;
    private String paciente;
    private String fechaCita;
    private double montoProcedimiento;
    private double montoMateriales;
    private double totalNeto;

    public CitaMedica() {
    }

    public CitaMedica(int idDentista, String paciente, double montoProcedimiento,
                      double montoMateriales, double totalNeto) {
        this.idDentista = idDentista;
        this.paciente = paciente;
        this.montoProcedimiento = montoProcedimiento;
        this.montoMateriales = montoMateriales;
        this.totalNeto = totalNeto;
    }

    public CitaMedica(int idCita, int idDentista, String paciente, String fechaCita,
                      double montoProcedimiento, double montoMateriales, double totalNeto) {
        this.idCita = idCita;
        this.idDentista = idDentista;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
        this.montoProcedimiento = montoProcedimiento;
        this.montoMateriales = montoMateriales;
        this.totalNeto = totalNeto;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public double getMontoProcedimiento() {
        return montoProcedimiento;
    }

    public void setMontoProcedimiento(double montoProcedimiento) {
        this.montoProcedimiento = montoProcedimiento;
    }

    public double getMontoMateriales() {
        return montoMateriales;
    }

    public void setMontoMateriales(double montoMateriales) {
        this.montoMateriales = montoMateriales;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }
}
