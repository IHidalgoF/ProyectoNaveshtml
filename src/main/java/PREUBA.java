
import org.hibernate.Session;
import org.hibernate.Transaction;

import Naves.HibernateUtil;
import Naves.entities.Usuarios;


public class PREUBA {
	public static void main(String[] args) {
	
		
		Usuarios u1 = new Usuarios();
		u1.setApellidos("sdgfdfgfas");
		u1.setContrasenya("srwerwersdff");
		u1.setNombre("sdas");
		u1.setUsuario("adfgdfgsas");

			
		Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.persist(u1);
        tx.commit();
	}
	
}
