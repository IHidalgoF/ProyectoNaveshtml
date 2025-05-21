package Naves.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Naves.entities.Guerrero;

public class Terminator extends Guerrero {
	private static final Logger logger = LoggerFactory.getLogger(Terminator.class);

	public Terminator(String nombre, String tipo) {
		super(nombre, tipo);
		
	}
	
	public Terminator(String nombre, String tipo, int fuerza, int resistencia) {
		super(nombre, tipo, fuerza, resistencia);
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Terminator []");
		return builder.toString();
	}

}
