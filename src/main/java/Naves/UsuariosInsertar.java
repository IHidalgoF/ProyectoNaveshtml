package Naves;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Naves.HibernateUtil;
import Naves.entities.Usuarios;


public class UsuariosInsertar {
	public static void main(String[] args) {
	
		
		Usuarios u1 = new Usuarios();
		u1.setApellidos("Perez");
		u1.setContrasenya("contrasenya1");
		u1.setNombre("Juan");
		u1.setUsuario("juan12a");

			
		Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(u1);
        tx.commit();
	}
	
}
