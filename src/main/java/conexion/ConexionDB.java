package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String DB_HOST = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
    

    private static final String URL = "jdbc:sqlserver://" + DB_HOST + ":1435;"
            + "databaseName=db_dentasmart;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";


    private  static  final  String USER ="sa";
    private  static  final  String PASWORD ="Password";
    private  static Connection conexion =null;

    private ConexionDB(){

    }

    public static Connection getConexion(){
        try {
            if (conexion==null || conexion.isClosed()){
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexion= DriverManager.getConnection(URL,USER,PASWORD);
                System.out.println("Conexion exitos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public  static  void  cerrarConexion(){
        try{


        if(conexion!=null  &&  !conexion.isClosed()){
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
