package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String DB_HOST = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
    private static final String DB_NAME = System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "db_dentasmart_control";
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "Password12345678";

    private static final String URL = "jdbc:sqlserver://" + DB_HOST + ":1435;"
            + "databaseName=" + DB_NAME + ";"
            + "encrypt=true;"
            + "trustServerCertificate=true;";


    private static final String USER = "sa";
    private static Connection conexion = null;

    private ConexionDB() {

    }

    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion = DriverManager.getConnection(URL, USER, DB_PASSWORD);
                System.out.println("Conexion exitos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void cerrarConexion() {
        try {


            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion cerrada exitosamente");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        getConexion();

    }


}
