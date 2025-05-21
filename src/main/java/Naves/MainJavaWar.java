package Naves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Naves.Excepciones.GuerrerosExcepcion;
import Naves.Excepciones.NaveCompletaExcepcion;
import Naves.Excepciones.TipoErrorGuerreroExcepcion;
import Naves.data.NaveDestructora;
import Naves.data.Soldado;
import Naves.data.Tanque;
import Naves.data.Terminator;
import Naves.entities.VehiculoGuerra;

public class MainJavaWar {
	
	private static final Logger logger = LoggerFactory.getLogger(MainJavaWar.class);

	public static void main(String[] args) throws NaveCompletaExcepcion, GuerrerosExcepcion, TipoErrorGuerreroExcepcion {
	    MainJavaWar mjw = new MainJavaWar();
	    logger.info("==================================================================");
		logger.info("EMPIEZA LA GUERRA");
		logger.info("==================================================================");
	    logger.info("* Creando Vehículos de Guerra. Embarcando Guerreros");
	        VehiculoGuerra nave1 = mjw.crearNaveDestructora();
	        VehiculoGuerra tanque1 = mjw.crearTanque();
	        logger.info("* Vehículos de Guerra creados: "+nave1.getNombre() + " y " + tanque1.getNombre());
	        logger.info("==================================================================");
	         mjw.batalla(nave1,tanque1);
	    
	      }


	
	private NaveDestructora crearNaveDestructora() throws GuerrerosExcepcion, TipoErrorGuerreroExcepcion {
		NaveDestructora nave1 = null;
		try {
			nave1 = new NaveDestructora("Odisea", "B",7,3);
			
		} catch (GuerrerosExcepcion e) {
			logger.error(e.getMessage());
		}
			Terminator terminator1 = new Terminator("B47", "terminator",8,2);
			Terminator terminator2 = new Terminator("B47", "terminator",5,5);
			Terminator terminator3 = new Terminator("B45", "terminator",2,8);
			Terminator terminator4 = new Terminator("B45", "terminator",3,7);
			Terminator terminator5 = new Terminator("B49", "terminator",6,4);
			Terminator terminator6 = new Terminator("B47", "terminator",8,2);
			Terminator terminator7 = new Terminator("B45", "terminator",8,2);
			Terminator terminator8 = new Terminator("B47", "terminator",8,2);
			Terminator terminator9 = new Terminator("B49", "terminator",8,2);
			Terminator terminator10 = new Terminator("B45", "terminator",8,2);
			
		
			
			
			try {
				nave1.embarcarGuerrero(terminator1);
				nave1.embarcarGuerrero(terminator2);
				nave1.embarcarGuerrero(terminator3);
				nave1.embarcarGuerrero(terminator4);
				nave1.embarcarGuerrero(terminator5);
				nave1.embarcarGuerrero(terminator6);
				nave1.embarcarGuerrero(terminator7);
				nave1.embarcarGuerrero(terminator8);
				nave1.embarcarGuerrero(terminator9);
				nave1.embarcarGuerrero(terminator10);
		
			} catch (NaveCompletaExcepcion e) {
				logger.error(e.getMessage());
			}
		
		return nave1;
	}

	private Tanque crearTanque() throws GuerrerosExcepcion, TipoErrorGuerreroExcepcion {//he quitado el bucle for y he añadigo guerreros del 	que admite el tipo de nave
		Tanque tanque1 = null;
		try {
			tanque1 = new Tanque("Pancer", "B",2, 8);
			
		} catch (GuerrerosExcepcion e) {
			logger.error("Tipo de Guerrero no permitido.");
		}
			Soldado soldado1 = new Soldado("Claudio", "soldado",1,1);
			Soldado soldado2 = new Soldado("Julio", "soldado",2,2);
			Soldado soldado3 = new Soldado("Augusto", "soldado", 0,2);
			Soldado soldado4 = new Soldado("Marcus", "soldado", 0,1);
			Soldado soldado5 = new Soldado("Agripina", "soldado", 0,2);
			try {
				tanque1.embarcarGuerrero(soldado1);
				tanque1.embarcarGuerrero(soldado2);
				tanque1.embarcarGuerrero(soldado3);
				tanque1.embarcarGuerrero(soldado4);
				tanque1.embarcarGuerrero(soldado5);
				
			} catch (NaveCompletaExcepcion e) {
				logger.error(e.getMessage());
			}
		return tanque1;
	}
	
	
	
	
	
	public void batalla(VehiculoGuerra nave1, VehiculoGuerra tanque1) {
		
		logger.info("ESTADO INICIAL DE VEHICULOS:");
		logger.info("NAVE1:\n "+ nave1);
		logger.info("NAVE2:\n "+tanque1);
		logger.info("EMPIEZA LA BATALLA");
		
		 while (nave1.getPuntosvida() > 0 && tanque1.getPuntosvida() > 0) {
		    		    
		    logger.info("==================================================================");
		    cabecera(nave1, tanque1);
		    logger.info("\nNAVE 1 ATACA:");
			int ataquenave1 = nave1.atacar();// aquí almacenamos el ataque de una de las naves
			logger.info("\nNAVE 2 DEFIENDE:");
			tanque1.defender(ataquenave1);
			
			
	
			if (tanque1.getPuntosvida() <= 0) {
				logger.info("\n"+tanque1.getNombre() + " ha sido destruida, fin del combate.");
				logger.info(nave1.getNombre() + " gana");
				break; // Salimos del bucle
			}
			logger.info("==================================================================");;
			cabecera(nave1, tanque1);	
			logger.info("\nNAVE 2 ATACA:");
			int ataquetanque1 = tanque1.atacar();// aquí almacenamos el ataque de una de las naves
			logger.info("\nNAVE 1 DEFIENDE:");
			nave1.defender(ataquetanque1);
			
			
			if (nave1.getPuntosvida() <= 0) {
				logger.info("\n"+nave1.getNombre() + " ha sido destruida, fin del combate.");
				logger.info(tanque1.getNombre() + " gana");
				break; // Salimos del bucle
			}
			try {
				Thread.sleep(1000); // Pausa de 1 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

public void batallaconProfe(VehiculoGuerra vehiculoprofe) {
		NaveDestructora nave1=null;
		try {
			nave1 = crearNaveDestructora();
		} catch (GuerrerosExcepcion e) {
				e.printStackTrace();
		} catch (TipoErrorGuerreroExcepcion e) {
						e.printStackTrace();
		}
		
		logger.info("ESTADO INICIAL DE VEHICULOS:");
		logger.info("NAVE1:\n "+ nave1);
		logger.info("NAVE2:\n "+vehiculoprofe);
		logger.info("EMPIEZA LA BATALLA");
		
		 while (nave1.getPuntosvida() > 0 && vehiculoprofe.getPuntosvida() > 0) {
		    		    
		    logger.info("==================================================================");
		    cabecera(nave1, vehiculoprofe);
		    logger.info("\nNAVE 1 ATACA:");
			int ataquenave1 = nave1.atacar();// aquí almacenamos el ataque de una de las naves
			logger.info("\nNAVE 2 DEFIENDE:");
			vehiculoprofe.defender(ataquenave1);
			
			
	
			if (vehiculoprofe.getPuntosvida() <= 0) {
				logger.info("\n"+vehiculoprofe.getNombre() + " ha sido destruida, fin del combate.");
				logger.info(nave1.getNombre() + " gana");
				break; // Salimos del bucle
			}
			logger.info("==================================================================");;
			cabecera(nave1, vehiculoprofe);	
			logger.info("\nNAVE 2 ATACA:");
			int ataquetanque1 = vehiculoprofe.atacar();// aquí almacenamos el ataque de una de las naves
			logger.info("\nNAVE 1 DEFIENDE:");
			nave1.defender(ataquetanque1);
			
			
			if (nave1.getPuntosvida() <= 0) {
				logger.info("\n"+nave1.getNombre() + " ha sido destruida, fin del combate.");
				logger.info(vehiculoprofe.getNombre() + " gana");
				break; // Salimos del bucle
			}
			try {
				Thread.sleep(1000); // Pausa de 1 segundo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void cabecera(VehiculoGuerra nave1, VehiculoGuerra tanque1) {
		logger.info("\t   " + nave1.getNombre() + "\t\t\t   " + tanque1.getNombre());
		String barra1 = barraVida(nave1);
		String barra2 = barraVida(tanque1);
		logger.info(barra1+"\t"+barra2);

	}

	public static String barraVida(VehiculoGuerra nave) {
		String linea = "";
		int vidaRestante = nave.getPuntosvida() / 20;
		linea = "[";
		for (int i = 0; i < vidaRestante; i++) {
			linea += "X";
		}
		for (int i = 0; i < 25 - vidaRestante; i++) {
			linea += "-";
		}
		linea += "]" + (100 * nave.getPuntosvida() / 500) + "%";
		return linea;

	}
}


