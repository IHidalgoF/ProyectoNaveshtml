package Naves.entities;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Naves.Excepciones.NaveCompletaExcepcion;
import Naves.Excepciones.TipoErrorGuerreroExcepcion;
import Naves.data.Tripulable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name="TB_VEHICULOGUERRA")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//porque es una clase padre
public class VehiculoGuerra  implements Tripulable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private static final Logger logger = LoggerFactory.getLogger(VehiculoGuerra.class);
	@Transient
	private int puntosvida;
	private String nombre;
	private String tipo;
	private int ataque;
	private int defensa;
	@OneToMany(mappedBy = "vehiculoguerra", cascade = CascadeType.ALL,fetch = FetchType.LAZY )//orphanRemoval = true no le he usado
	private List<Guerrero> guerreros=new ArrayList<>();
	
	

	
	public VehiculoGuerra() {
	
	}



	public VehiculoGuerra(String nombre, String tipo, int ataque, int defensa) {
	    super();
	    // Verificar si la suma de ataque y defensa es mayor que 10
	    if (ataque + defensa > 10) {
	        // Establecer los valores por defecto si la suma es mayor que 10
	        this.ataque = 5;
	        this.defensa = 5;
	        this.nombre = nombre;
	        this.tipo = tipo;
	        this.puntosvida = 500;
	        this.guerreros = new ArrayList<>();
	        
	        // Advertir que se ajustaron los valores
	        logger.warn("Ataque + defensa del Vehículo de Guerra > 10. Valores en defensa y ataque ajustados a 5.");
	    } else {
	        // Si no exceden, asignar los valores proporcionados
	        this.ataque = ataque;
	        this.defensa = defensa;
	        this.nombre = nombre;
	        this.tipo = tipo;
	        this.puntosvida = 500;
	        this.guerreros = new ArrayList<>();
	    }	  
    
	    
	}

	public int getPuntosvida() {
		return puntosvida;
	}
	
	
	
	public void setPuntosvida(int puntosvida) {
		if(puntosvida>500) {
			  logger.warn("Los puntos de vida no pueden ser mayores a 500");
			  this.puntosvida = 500;
		}
		else {
		this.puntosvida=puntosvida;
	}
	}
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getAtaque() {
		return ataque;
	}



	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}



	public int getDefensa() {
		return defensa;
	}



	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}



	public List<Guerrero> getGuerreros() {
		return guerreros;
	}



	public void setGuerreros(List<Guerrero> guerreros) {
		this.guerreros = guerreros;
	}



	public static Logger getLogger() {
		return logger;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehiculoGuerra [puntosvida=");
		builder.append(puntosvida);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", ataque=");
		builder.append(ataque);
		builder.append(", defensa=");
		builder.append(defensa);
		builder.append(", guerreros=");
		builder.append(guerreros);
		builder.append("]");
		return builder.toString();
	}

	public void embarcarGuerrero(Guerrero guerreros) throws NaveCompletaExcepcion, TipoErrorGuerreroExcepcion {

		if(this.guerreros.size()>=10) {
				throw new NaveCompletaExcepcion ("La nave "+ nombre+" está completa. No se pueden embarcar más guerreros");
		}else {
			this.guerreros.add(guerreros);
		
			
		}
	}



	@Override
	public int atacar() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void defender(int ataque) {
		// TODO Auto-generated method stub
		
	}

}
