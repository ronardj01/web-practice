package dbentidades;

import entidades.Personaje;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBPersonaje {

    //Insertar personaje en la base de Datos Personaje
    public static ArrayList<Personaje> getAllChar() throws SQLException {
        ArrayList<Personaje> personajes = new ArrayList<>();
        String query = "SELECT id, nombre FROM personajes";
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while (rs.next()) {
            Personaje personaje = new Personaje();
            personaje.setId(rs.getInt("id"));
            personaje.setNombre(rs.getString("nombre"));
            personajes.add(personaje);
        }
       
        return personajes;
    }
}
