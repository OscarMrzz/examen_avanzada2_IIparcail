package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                CitaMedica cita = new CitaMedica();

                cita.setIdCita(rs.getInt(1));
                cita.setIdDentista(rs.getInt(2));
                cita.setPaciente(rs.getString(3));
                cita.setFechaCita(Utils.formatearFecha(rs.getObject(4)));
                cita.setMontoProcedimiento(rs.getDouble(5));
                cita.setMontoMateriales(rs.getDouble(6));
                cita.setTotalNeto(rs.getDouble(7));

                citas.add(cita);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return citas;
    }

    public CitaMedica getById(int id) {
        CitaMedica cita = new CitaMedica();
        String query = "SELECT * FROM citas_medicas WHERE id_cita = ?";
        try {
            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                cita.setIdCita(rs.getInt(1));
                cita.setIdDentista(rs.getInt(2));
                cita.setPaciente(rs.getString(3));
                cita.setFechaCita(Utils.formatearFecha(rs.getObject(4)));
                cita.setMontoProcedimiento(rs.getDouble(5));
                cita.setMontoMateriales(rs.getDouble(6));
                cita.setTotalNeto(rs.getDouble(7));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cita;

    }

    public boolean create(CitaMedica cita) {
        String query = "INSERT INTO citas_medicas (id_dentista, paciente, monto_procedimiento, monto_materiales, total_neto) "
                + "VALUES (?, ?, ?, ?, ?);";
        try {

            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, cita.getIdDentista());
            ps.setString(2, cita.getPaciente());
            ps.setDouble(3, cita.getMontoProcedimiento());
            ps.setDouble(4, cita.getMontoMateriales());
            ps.setDouble(5, cita.getTotalNeto());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(CitaMedica cita) {
        String query = "UPDATE citas_medicas SET id_dentista=?, paciente=?, monto_procedimiento=?, monto_materiales=?, total_neto=? WHERE id_cita=?;";
        try {

            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, cita.getIdDentista());
            ps.setString(2, cita.getPaciente());
            ps.setDouble(3, cita.getMontoProcedimiento());
            ps.setDouble(4, cita.getMontoMateriales());
            ps.setDouble(5, cita.getTotalNeto());
            ps.setInt(6, cita.getIdCita());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM citas_medicas WHERE id_cita=?;";
        try {

            Connection conn = ConexionDB.getConexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
