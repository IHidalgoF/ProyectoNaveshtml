package Naves.Excepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NaveCompletaExcepcion  extends Exception {
	private static final Logger logger = LoggerFactory.getLogger(NaveCompletaExcepcion.class);
		public NaveCompletaExcepcion (String mensaje) {
			super (mensaje);
			}
	
}
