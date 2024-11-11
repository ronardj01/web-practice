package dbentidades;

import java.sql.*;
import java.util.*;
import entidades.Producto;

public class ProductoDAO {

    public ProductoDAO() {
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jspcrud?useSSL=false&allowPublicKeyRetrieval=true", "root", "12345678");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public static void deleteChar(int id) throws SQLException {
        String query = "DELETE FROM `producto` WHERE (`id` = '" + id + "')";
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();

        stm.executeUpdate(query);
        stm.close();
    }

    public static Producto searchChar(int id) throws SQLException {
        Producto producto = new Producto();
        String query = "SELECT id, nombre FROM producto Where id = ' " + id + "'";
        Connection conn = DBConnection.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            producto.setId(rs.getInt("id"));
            producto.setNombre("nombre");
        }
        return producto;
    }

    public void updateChar(int oldID, Producto newChar) throws SQLException {
        String query = "UPDATE producto SET nombre = ? WHERE id = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, newChar.getNombre());
        stmt.setInt(2, oldID);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    private Connection connection;

    // Agregar un nuevo producto
    public boolean agregar(Producto producto) {
        boolean res = false;
        try {
            String sql = "INSERT INTO producto (nombre) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, producto.getNombre());
            res = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Producto obtenerPorId(int id) {
        Producto producto = null;
        try {
            String sql = "SELECT * FROM producto WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = new Producto(rs.getInt("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }
}
