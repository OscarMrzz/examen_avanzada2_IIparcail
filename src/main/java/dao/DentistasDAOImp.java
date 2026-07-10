package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.ConexionDB;

import modelo.Dentista;

public class DentistasDAOImp implements DentistasDAO {

    public List<Dentista> getAll() {

        List<Dentista> dentistas = new ArrayList<>();

        String query = "SELECT * FROM dentistas;";

        try {
            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                /*
                 * private int idDentista;
                 * private String nombre;
                 * private String apellido;
                 * private String especialidad;
                 * private double salarioBase;
                 * private String estado;
                 * 
                 * 
                 */
                Dentista dentista = new Dentista();

                dentista.setIdDentista(rs.getInt(0));
                dentista.setNombre(rs.getString(1));
                dentista.setApellido(rs.getString(2));
                dentista.setEspecialidad(rs.getString(3));
                dentista.setSalarioBase(rs.getDouble(4));
                dentista.setEstado(rs.getString(5));

                dentistas.add(dentista);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

        return dentistas;
    }

    public Dentista getById(int id) {
        Dentista dentista = new Dentista();
        String query = "SELECT * from dentista WHERE id_dentist =?";
        try{
            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                 dentista.setIdDentista(rs.getInt(0));
                dentista.setNombre(rs.getString(1));
                dentista.setApellido(rs.getString(2));
                dentista.setEspecialidad(rs.getString(3));
                dentista.setSalarioBase(rs.getDouble(4));
                dentista.setEstado(rs.getString(5));

            
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            
        }

        return dentista;

    }

    public boolean create(Dentista dentista) {
        String query = "INSERT INTO dentistas (nombre, apellido, especialidad, salario_base, estado) "
                 + "VALUES (?, ?, ?, ?, ?);";
try{

    Connection conn = ConexionDB.getConexion();
    PreparedStatement ps = conn.prepareStatement(query);

    ps.setString(0, dentista.getNombre());
    ps.setString(1, dentista.getApellido());
    ps.setString(2, dentista.getEspecialidad());
    ps.setDouble(3, dentista.getSalarioBase());
    ps.setString(4, dentista.getEstado());

    int filasAfectadas = ps.executeUpdate();

    return filasAfectadas>0;

} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    return false;
}finally{}
                 
        
    }

    public boolean update(int id) {
        Dentista dentista = new Dentista();
        String query = "UPDATE dentistas SET nombre=?, apellido=?, especialidad=?, salario_base=?, estado=? WHERE id_dentista=?;";
        try {

            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(0, dentista.getNombre());
            ps.setString(1, dentista.getApellido());
            ps.setString(2, dentista.getEspecialidad());
            ps.setDouble(3, dentista.getSalarioBase());
            ps.setString(4, dentista.getEstado());
            ps.setInt(5, id);

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
        String query = "DELETE FROM dentistas WHERE id_dentista=?;";
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
