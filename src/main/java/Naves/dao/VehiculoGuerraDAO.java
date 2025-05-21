package Naves.dao;

import org.hibernate.Session;
import Naves.entities.VehiculoGuerra;
import Naves.HibernateUtil;

public class VehiculoGuerraDAO {

    public void save(VehiculoGuerra vehiculoGuerra) {
        Session session = null;
        try {
            // Obtener una nueva sesión
            session = HibernateUtil.getSession();
            
            // Iniciar transacción
            session.beginTransaction();
            
            // Guardar el objeto
            session.save(vehiculoGuerra);
            
            // Confirmar transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback(); // Revertir cambios en caso de error
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión
            HibernateUtil.closeSession(session);
        }
    }
}

