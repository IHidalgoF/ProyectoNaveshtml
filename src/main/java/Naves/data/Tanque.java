package Naves.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Naves.Excepciones.GuerrerosExcepcion;
import Naves.Excepciones.NaveCompletaExcepcion;
import Naves.Excepciones.TipoErrorGuerreroExcepcion;
import Naves.entities.Guerrero;
import Naves.entities.VehiculoGuerra;

public class Tanque extends VehiculoGuerra {
	private static final Logger logger = LoggerFactory.getLogger(Tanque.class);

	public Tanque(String nombre, String tipo, int ataque, int defensa) throws GuerrerosExcepcion {
		super(nombre, tipo, ataque, defensa);
	}



	@Override
	public int atacar() {
		double fuerzas = 0;
		for (Guerrero guerrero : getGuerreros()) {
			fuerzas += guerrero.getFuerza();
		}
		double total = getAtaque() * Math.random() + fuerzas * Math.random() / 2;
		int totalfinal = (int) total;
		logger.info(" "+getNombre() + " ataca con " + totalfinal + " puntos");
		return totalfinal;
	}

	@Override
	public void defender(int ataque) {
		double defensas = 0;
		for (Guerrero guerrero : getGuerreros()) {
			defensas += guerrero.getResistencia();
		}
		double totaldefensa = getDefensa() * Math.random() + getDefensa() * Math.random() / 2;
		int totaldeffinal = (int) totaldefensa;
		logger.info(" "+getNombre() + " se defiende con " + totaldeffinal + " puntos");
		logger.info("\nRESULTADO:");
		if (ataque > totaldeffinal) {
			int diferencia = ataque - totaldeffinal;
			logger.info(" "+getNombre() + " pierde " + diferencia + " puntos de vida");
			int vidaactualizada = getPuntosvida() - diferencia;
			setPuntosvida(vidaactualizada);
		} else {
			logger.info(" "+getNombre() + " no pierde puntos de vida");
		}
	}

	@Override
	public void embarcarGuerrero(Guerrero guerrero) throws TipoErrorGuerreroExcepcion, NaveCompletaExcepcion {
		if (guerrero instanceof Soldado) {
			super.embarcarGuerrero(guerrero);

		} else {
			throw new TipoErrorGuerreroExcepcion("Solo los guerreros tipo Soldado pueden embarcar en una Tanque.");
		}
	}
	

}
