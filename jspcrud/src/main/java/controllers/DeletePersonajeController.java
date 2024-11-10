
package controllers;

import dbentidades.DBPersonaje;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;



@WebServlet(name = "DeletePersonajeController", urlPatterns = {"/DeletePersonajeController"})
public class DeletePersonajeController extends HttpServlet {

  
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
        RequestDispatcher rd = request.getRequestDispatcher("EliminarPersonaje.jsp");
        rd.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje = "";
        String nombre = request.getParameter("nombre");
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            DBPersonaje.deleteChar(id);
            mensaje = "El Personaje se ha elminiado de la base de datos";
        } catch (SQLException ex) {
            System.out.println("El Personaje no se ha eliminado");
            System.out.println(ex.getMessage());
        }
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher rd = request.getRequestDispatcher("ConfirmUpdateChar.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
