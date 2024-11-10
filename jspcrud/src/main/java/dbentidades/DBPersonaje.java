package dbentidades;

import entidades.Personaje;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DBPersonaje {

    //mostrar todas las personaje de la base de Datos Personaje
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
        conn.close();

        return personajes;
    }

    public static void insertChar(Personaje personaje) throws SQLException {
        String query = "INSERT INTO `personajes` (`nombre`) VALUES ('" + personaje.getNombre() + "')";
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();

        stm.executeUpdate(query);
        conn.close();
    }

    public static Personaje searchChar(int id) throws SQLException {
        Personaje personaje = new Personaje();
        String query = "SELECT id, nombre FROM personajes Where id = ' " + id + "'";
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
        while(rs.next()) {
            personaje.setId(rs.getInt("id"));
            personaje.setNombre("nombre");
        }
    return personaje;
    }
    
    public static void updateChar(int oldID, Personaje newChar) throws SQLException{
        String query = "UPDATE `personajes` SET `nombre` = '" + newChar.getNombre() + "' WHERE (`id` = '" + oldID + "')";
        System.out.println(query);
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();
        
        stm.executeUpdate(query);
        conn.close();
    }
    
    public static void deleteChar(int id) throws SQLException{
        String query = "DELETE FROM `personajes` WHERE (`id` = '" + id + "')";
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();
        
        stm.executeUpdate(query);
        stm.close();
    }
}



