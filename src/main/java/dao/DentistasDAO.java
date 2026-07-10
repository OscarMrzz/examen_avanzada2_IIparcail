package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Dentista;

public interface DentistasDAO {

    List<Dentista> getAll() throws SQLException;
    Dentista getById(int id);
    boolean create(Dentista dentista);
    boolean update(int id);
    boolean delete(int id);

}
