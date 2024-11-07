package dbentidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {


    private static final String URL = "jdbc:mysql://localhost/jspcrud?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = System.getenv("DB_USER_PRUEBA");
    private static final String PASS = System.getenv("DB_PASS_PRUEBA");


    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("¡La conexión se ha establecido correctamente!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("¡La conexión no se ha podido establecer correctamente!");
        }
        return conn;
    }
}


