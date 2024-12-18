
package controllers;

import dbentidades.DBPersonaje;
import entidades.Personaje;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;


@WebServlet(name = "ModificarPersonajesController", urlPatterns = {"/ModificarPersonajesController"})
public class ModificarPersonajesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre").replace("_", " ");
        request.setAttribute("id", id);
        request.setAttribute("nombre", nombre);
        RequestDispatcher rd = request.getRequestDispatcher("ModificarPersonaje.jsp");
        rd.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nuevoNombre = request.getParameter("nombre");
        int viejoId = Integer.parseInt(request.getParameter("id"));
        Personaje personaje = new Personaje();
        personaje.setNombre(nuevoNombre);
        String mensaje = "";
        
        try {
            DBPersonaje.updateChar(viejoId, personaje);
            mensaje = "El Personaje se actualizo correctamente"; 
        } catch (SQLException ex) {
           ex.getMessage();
           mensaje = "El Personaje no se ha podido modificar";
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
