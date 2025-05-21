package Naves.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Naves.entities.Guerrero;

public class Soldado extends Guerrero {
	private static final Logger logger = LoggerFactory.getLogger(Soldado.class);


	public Soldado(String nombre, String tipo, int fuerza, int resistencia) {
		super(nombre, tipo, fuerza, resistencia);
		
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Soldado [getTipo()=");
		builder.append(getTipo());
		builder.append(", getFuerza()=");
		builder.append(getFuerza());
		builder.append(", getResistencia()=");
		builder.append(getResistencia());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}
	

}
