package Naves.Servlets;

import java.io.IOException;
import java.util.List;

import Naves.dao.DAOImp;
import Naves.dto.GuerreroDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NavesServlet")
public class NavesServlet extends HttpServlet {
    private DAOImp guerreroDAO;

    @Override
    public void init() throws ServletException {
        // Crear la instancia del DAO
        guerreroDAO = new GuerreroDAOImp();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operacion = request.getParameter("operacion");

        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String ataque = request.getParameter("ataque");
        String defensa = request.getParameter("defensa");
        String id = request.getParameter("id");

        // Crear un objeto DTO de Guerrero
        GuerreroDTO guerrero = new GuerreroDTO();
        guerrero.setNombre(nombre);
        guerrero.setTipo(tipo);
        guerrero.setAtaque(ataque);
        guerrero.setDefensa(defensa);

        if ("insertar".equals(operacion)) {
            // Insertar guerrero
            guerreroDAO.insertarGuerrero(guerrero);
            response.sendRedirect("NavesServlet?action=listar");

        } else if ("actualizar".equals(operacion)) {
            // Actualizar guerrero
            if (id != null) {
                guerrero.setId(Long.parseLong(id));
                guerreroDAO.actualizarGuerrero(guerrero);
            }
            response.sendRedirect("NavesServlet?action=listar");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("listar".equals(action)) {
            // Consultar los guerreros
            List<GuerreroDTO> guerreros = guerreroDAO.listarGuerreros();
            request.setAttribute("guerreros", guerreros);  // Pasamos la lista al JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("listadoGuerreros.jsp");
            dispatcher.forward(request, response);
        }
    }
}
