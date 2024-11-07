
package controllers;

import dbentidades.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import entidades.Producto;


@WebServlet(name = "ActualizarProducto", urlPatterns = {"/ActualizarProducto"})
public class ActualizarProductoServlet extends HttpServlet {
    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();  // Inicializa el DAO para la base de datos
    }

    // Mostrar el formulario para actualizar un producto
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));  // Obtener el ID del producto a actualizar
        Producto producto = (Producto) productoDAO.obtenerPorId(id);  // Obtener el producto desde la base de datos
        request.setAttribute("producto", producto);  // Pasar el producto a la vista
        request.getRequestDispatcher("/actualizarProducto.jsp").forward(request, response);  // Redirigir a la página para actualizar
    }

    // Recibir los datos del formulario y actualizar el producto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");  // Recibir el nuevo nombre del producto
        Producto producto = new Producto(id, nombre);  // Crear un objeto Producto con los nuevos datos
        if (productoDAO.actualizar(producto)) {
            response.sendRedirect("ProductoServlet?action=mostrar");  // Redirigir a la lista de productos
        } else {
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarProducto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
