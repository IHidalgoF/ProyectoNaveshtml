package Naves.dao;

import java.util.List;

import org.hibernate.Session;

import Naves.HibernateUtil;
import Naves.entities.Usuarios;


public class UsuariosDAOImpl implements UsuariosDAO {
	@Override
	public List<Usuarios> findAll() {
		System.out.println("hola");
		Session session = HibernateUtil.getSession();
		List<Usuarios> lista = session.createQuery("from Usuarios",Usuarios.class).list();
		System.out.println(lista);
		return lista;
	}


}
