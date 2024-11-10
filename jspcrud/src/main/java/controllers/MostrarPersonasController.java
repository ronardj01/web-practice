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
import java.util.ArrayList;

@WebServlet(name = "MostrarPersonasController", urlPatterns = {"/MostrarPersonasController"})
public class MostrarPersonasController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ArrayList<Personaje> personajes = DBPersonaje.getAllChar();
            request.setAttribute("personajes", personajes);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("MostrarPersonajes.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Personaje newPersonaje = new Personaje();
        newPersonaje.setNombre(nombre);
        String mensaje = "";
        try {
            DBPersonaje.insertChar(newPersonaje);
            mensaje = "Se ha agreagado el personaje correctamente en la base de datos";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            mensaje = "No se ha podido ingresar el personaje en la base datos";
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
