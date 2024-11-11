package controllers;

import dbentidades.DBPersonaje;
import dbentidades.ProductoDAO;
import entidades.Personaje;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entidades.Producto;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ActualizarProductoServlet", urlPatterns = {"/ActualizarProductoServlet"})
public class ActualizarProductoServlet extends HttpServlet {

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();  // Inicializa el DAO para la base de datos
    }

    // Mostrar el formulario para actualizar un producto
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre").replace("_", " ");
        request.setAttribute("id", id);
        request.setAttribute("nombre", nombre);
        RequestDispatcher rd = request.getRequestDispatcher("ModificarProducto.jsp");
        rd.forward(request, response);
    }

    // Recibir los datos del formulario y actualizar el producto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nuevoNombre = request.getParameter("nombre");
        int viejoId = Integer.parseInt(request.getParameter("id"));
        Producto producto = new Producto();
        producto.setNombre(nuevoNombre);
        String mensaje = "";

        try {
            productoDAO.updateChar(viejoId, producto); // Cambia la llamada a un método no estático
            mensaje = "El Producto se actualizó correctamente";
        } catch (SQLException ex) {
            ex.printStackTrace();
            mensaje = "No se pudo modificar el Producto";
        }

        request.setAttribute("mensaje", mensaje);
        RequestDispatcher rd = request.getRequestDispatcher("ConfirmUpdateChar.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
