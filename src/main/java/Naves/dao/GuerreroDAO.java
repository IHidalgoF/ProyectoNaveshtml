package Naves.dao;

import org.hibernate.Session;
import Naves.entities.Guerrero;
import Naves.HibernateUtil;

public class GuerreroDAO {

    public void save(Guerrero guerrero) {
        Session session = null;
        try {
            session = HibernateUtil.getSession(); // Obtener una sesión nueva
            session.beginTransaction(); // Iniciar transacción
            session.save(guerrero); // Guardar el objeto
            session.getTransaction().commit(); // Confirmar transacción
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback(); // En caso de error, revertir
            }
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session); // Cerrar la sesión
        }
    }
}
