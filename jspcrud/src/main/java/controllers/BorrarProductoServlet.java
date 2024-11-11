package controllers;

import dbentidades.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "BorrarProductoServlet", urlPatterns = {"/BorrarProductoServlet"})
public class BorrarProductoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre").replace("_", " ");
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("nombre", nombre);
        request.setAttribute("id", id);
        RequestDispatcher rd = request.getRequestDispatcher("EliminarProducto.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje = "";
        String nombre = request.getParameter("nombre");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            ProductoDAO.deleteChar(id);
        } catch (SQLException ex) {
            Logger.getLogger(BorrarProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        mensaje = "El Producto se ha elminiado de la base de datos";
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher rd = request.getRequestDispatcher("ConfirmUpdateChar.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
