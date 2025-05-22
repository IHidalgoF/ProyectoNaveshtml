package Naves.Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/accesoServlet")
public class AccesoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("usuario");
        String password = request.getParameter("contrasenya");
        
        //LoginDao dao = new LoginDAOImpl();
        
        //List<Usuarios> usuarios = dao.consutarUsuarios();
        		
        // Lógica de validación (puedes hacerlo contra una base de datos SQL)
        if (username.equals("admin") && password.equals("12345")) {
            // Si la autenticación es exitosa, redirige a la página de inicio
            response.sendRedirect("TablaGuerreros.html");
        } else {
            // Si el login falla, redirige de nuevo al login
            response.sendRedirect("login.jsp");
        }
    }
}