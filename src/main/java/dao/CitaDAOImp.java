package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import conexion.ConexionDB;

import modelo.CitaMedica;
import utils.Utils;

public class CitaDAOImp implements CitasDAO {

    public List<CitaMedica> getAll() {

        List<CitaMedica> citas = new ArrayList<>();

        String query = "SELECT * FROM citas_medicas;";

        try {
            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                /*
                 * private int idCita;
                 * private int idDentista;
                 * private String paciente;
                 * private String fechaCita;
                 * private double montoProcedimiento;
                 * private double montoMateriales;
                 * private double totalNeto;
                 * 
                 * 
                 */
                CitaMedica cita = new CitaMedica();

                cita.setIdCita(rs.getInt(0));
                cita.setPaciente(rs.getString(1));
                cita.setFechaCita(Utils.formatearFecha(rs.getObject(2)));
                cita.setMontoProcedimiento(rs.getDouble(3));
                cita.setMontoMateriales(rs.getDouble(4));
                cita.setTotalNeto(rs.getDouble(5));

                citas.add(cita);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

        return citas;
    }

    public CitaMedica getById(int id) {
        CitaMedica cita = new CitaMedica();
        String query = "SELECT * from cita_medica WHERE id_cinta =?";
        try{
            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                 cita.setIdCita(rs.getInt(0));
                cita.setPaciente(rs.getString(1));
                cita.setFechaCita(Utils.formatearFecha(rs.getObject(2)));
                cita.setMontoProcedimiento(rs.getDouble(3));
                cita.setMontoMateriales(rs.getDouble(4));
                cita.setTotalNeto(rs.getDouble(5));

            
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            
        }

        return cita;

    }

    public boolean create(CitaMedica cita) {
        String query = "INSERT INTO citas_medicas (id_dentista, paciente, fecha_cita, monto_procedimiento, monto_materiales, total_neto) "
                 + "VALUES (?, ?, ?, ?, ?, ?);";
try{

    Connection conn = ConexionDB.getConexion();
    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(0, cita.getIdDentista());
    ps.setString(1, cita.getPaciente());
    ps.setString(2, cita.getFechaCita());
    ps.setDouble(3, cita.getMontoProcedimiento());
    ps.setDouble(4, cita.getMontoMateriales());
    ps.setDouble(5, cita.getTotalNeto());

    int filasAfectadas = ps.executeUpdate();

    return filasAfectadas>0;

} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    return false;
}finally{}
                 
        
    }

    public boolean update(int id) {
        CitaMedica cita = new CitaMedica();
        String query = "UPDATE citas_medicas SET id_dentista=?, paciente=?, fecha_cita=?, monto_procedimiento=?, monto_materiales=?, total_neto=? WHERE id_cita=?;";
        try {

            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(0, cita.getIdDentista());
            ps.setString(1, cita.getPaciente());
            ps.setString(2, cita.getFechaCita());
            ps.setDouble(3, cita.getMontoProcedimiento());
            ps.setDouble(4, cita.getMontoMateriales());
            ps.setDouble(5, cita.getTotalNeto());
            ps.setInt(6, id);

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM citas_medicas WHERE id_cita=?;";
        try {

            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(0, id);

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
        }
    }
}
