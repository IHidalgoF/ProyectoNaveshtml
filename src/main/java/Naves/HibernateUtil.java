package Naves;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Cargar la configuración de Hibernate
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al crear la SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método para obtener una nueva sesión
    public static Session getSession() {
        return sessionFactory.openSession(); // Devuelve una nueva sesión
    }

    // Método para cerrar la sesión
    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    // Método para cerrar el SessionFactory (no es necesario cerrar cada vez, solo cuando finalizas la aplicación)
    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
