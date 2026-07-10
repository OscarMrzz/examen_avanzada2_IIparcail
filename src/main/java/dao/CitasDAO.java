package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.CitaMedica;

public interface CitasDAO {

    List<CitaMedica> getAll() throws SQLException;
    CitaMedica getById(int id);
    boolean create(CitaMedica cita);
    boolean update(CitaMedica cita);
    boolean delete(int id);
    

}
