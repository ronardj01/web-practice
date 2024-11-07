package newpackage;

import java.sql.*;
import java.util.*;

public class ProductoDAO {

    private Connection connection;

    public ProductoDAO() {
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appmvcmodulo3", "root", "12345678");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Producto");
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    // Agregar un nuevo producto
    public boolean agregar(Producto producto) {
        boolean res = false;
        try {
            String sql = "INSERT INTO Producto (nombre) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, producto.getNombre());
            res = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    // Actualizar un producto existente
    public boolean actualizar(Producto producto) {
        boolean res = false;
        try {
            String sql = "UPDATE Producto SET nombre = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getId());
            res =  stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    // Borrar un producto
    public boolean borrar(int id) {
        boolean res = false;
        try {
            String sql = "DELETE FROM Producto WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            res = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    Producto obtenerPorId(int id) {
        Producto producto = null;
        try {
            String sql = "SELECT * FROM Producto WHERE id = ?";
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
