package controllers;

import dbentidades.ProductoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import entidades.Producto;
import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            // Mostrar todos los productos
            List<Producto> productos = productoDAO.obtenerTodos();
            if (productos == null || productos.isEmpty()) {
                productos = new ArrayList<>(); // Inicializa la lista para evitar el NullPointerException
            }
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("/Productos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
            String nombre = request.getParameter("nombre");
            Producto producto = new Producto(0, nombre); // ID se asigna automáticamente
            productoDAO.agregar(producto);
            String mensaje = "Se ha agregado el producto correctamente";
            request.setAttribute("mensaje", mensaje);
            RequestDispatcher rd = request.getRequestDispatcher("ConfirmUpdateChar.jsp");
            rd.forward(request, response);
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
