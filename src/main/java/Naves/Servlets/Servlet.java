package Naves.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/guardarVehiculoYGuerrero")
public class GuardarVehiculoYGuerreroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Aquí recoges los parámetros y procesas los datos
        String nombre = request.getParameter("nombre");
        // Guardar en BBDD...
    }
}

