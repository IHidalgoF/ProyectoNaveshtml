package Naves.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Naves.HibernateUtil;
import Naves.dto.GuerreroDTO;
import Naves.entities.Guerrero;

public class GuerreroDAOImp implements DAOImp {

    @Override
    public void insertarGuerrero(Guerrero guerrero) {
        Session session = HibernateUtil.getSession(); // Obtener sesión de Hibernate
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(guerrero); // Insertar el objeto Guerrero en la base de datos
            transaction.commit(); // Commit de la transacción
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback si ocurre algún error
            }
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarGuerrero(GuerreroDTO guerrero) {
        Session session = HibernateUtil.getSession(); // Obtener sesión de Hibernate
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(guerrero); // Actualizar el objeto Guerrero en la base de datos
            transaction.commit(); // Commit de la transacción
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback si ocurre algún error
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<GuerreroDTO> listarGuerreros() {
        Session session = HibernateUtil.getSession(); // Obtener sesión de Hibernate
        List<GuerreroDTO> guerreros = null;

        try {
            guerreros = session.createQuery("from GuerreroDTO", GuerreroDTO.class).list(); // Consultar todos los guerreros
        } catch (Exception e) {
            e.printStackTrace();
        }

        return guerreros;
    }

    @Override
    public GuerreroDTO obtenerGuerreroPorId(long id) {
        Session session = HibernateUtil.getSession(); // Obtener sesión de Hibernate
        GuerreroDTO guerrero = null;

        try {
            guerrero = session.get(GuerreroDTO.class, id); // Buscar un guerrero por su id
        } catch (Exception e) {
            e.printStackTrace();
        }

        return guerrero;
    }
}
