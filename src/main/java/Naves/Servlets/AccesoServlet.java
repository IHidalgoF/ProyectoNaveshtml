package Naves.Servlets;

import java.io.IOException;
import java.util.List;

import Naves.dao.UsuariosDAO;
import Naves.dao.UsuariosDAOImpl;
import Naves.entities.Usuarios;
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
        
        UsuariosDAO dao = new UsuariosDAOImpl();
        
        List<Usuarios> usuarios = dao.findAll();
        System.out.println(usuarios.size())	;
        boolean autenticado = false;
        
        // Lógica para verificar si el nombre de usuario y la contraseña coinciden con alguno de los usuarios en la lista
        for (Usuarios usuario : usuarios) {
        	System.out.println(usuario);
            if (usuario.getUsuario().equals(username) && usuario.getContrasenya().equals(password)) {
                autenticado = true;
                break; // Si encontramos una coincidencia, salimos del bucle
            }
        }

        // Si la autenticación es exitosa, redirige a la página de inicio, de lo contrario, al login
        if (autenticado) {
            response.sendRedirect("TablaGuerreros.html");
        } else {
            response.sendRedirect("acceso.jsp");
        }
    }
}