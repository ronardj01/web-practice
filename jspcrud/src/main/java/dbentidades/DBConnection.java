package dbentidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

<<<<<<< HEAD
    private static final String URL = "jdbc:mysql://localhost/jspcrud?userSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "12345678";

=======
    private static final String URL = "jdbc:mysql://localhost/jspcrud?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = System.getenv("DB_USER_PRUEBA");
    private static final String PASS = System.getenv("DB_PASS_PRUEBA");
    
>>>>>>> 5a2abd6beaf21f6e2c4d1e59f5cc6b5993ec9d5e
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


