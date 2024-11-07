package controllers;

import dbentidades.ProductoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entidades.Producto;

@WebServlet(name = "NuevoProductoServlet", urlPatterns = {"/NuevoProductoServlet"})
public class NuevoProductoServlet extends HttpServlet {

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();  // Inicializa el DAO para la base de datos
    }

    // Mostrar el formulario para agregar un nuevo producto
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/nuevoProducto.jsp").forward(request, response);  // Redirigir al formulario para agregar
    }

    // Recibir los datos del formulario y agregar un nuevo producto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");  // Recibir el nombre del producto
        Producto producto = new Producto(0, nombre);  // Crear un nuevo objeto Producto
        if (productoDAO.agregar(producto)) {
            response.sendRedirect("ProductoServlet?action=mostrar");  // Redirigir a la lista de productos después de agregar
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
