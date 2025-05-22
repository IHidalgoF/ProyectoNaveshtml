package Naves.entities;

import org.hibernate.validator.internal.util.logging.LoggerFactory;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_GUERRERO")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Guerrero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private static final Logger logger = LoggerFactory.getLogger(Guerrero.class);
	private String nombre;
	private String tipo;
	private double fuerza;
	private double resistencia;
	@ManyToOne
	@JoinColumn(name = "FK_VEHICULOGUERRA")
	private VehiculoGuerra vehiculoguerra;
	
	
	public Guerrero() {
	
	}


	public Guerrero(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	
	public Guerrero(String nombre, String tipo, int fuerza, int resistencia) {
	    super();
	    // Verificar si la suma de fuerza y resistencia es mayor que 10
	    if (fuerza + resistencia > 10) {
	        // Establecer los valores por defecto
	        this.fuerza = 5.00;
	        this.resistencia = 5.00;
	        
	        // Advertir que se ajustaron los valores
	        logger.warn("Fuerza + resistencia del guerrero > 10. Valores fuerza y resistencia ajustados a 5");
	    } else {
	        // Si no exceden, asignar los valores proporcionados
	        this.fuerza = fuerza;
	        this.resistencia = resistencia;
	        this.nombre=nombre;
	        this.tipo=tipo;
	    }
	}


	
		
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public double getFuerza() {
		return fuerza;
	}


	public void setFuerza(double fuerza) {
		this.fuerza = fuerza;
	}


	public double getResistencia() {
		return resistencia;
	}


	public void setResistencia(double resistencia) {
		this.resistencia = resistencia;
	}


	public VehiculoGuerra getVehiculoguerra() {
		return vehiculoguerra;
	}


	public void setVehiculoguerra(VehiculoGuerra vehiculoguerra) {
		this.vehiculoguerra = vehiculoguerra;
	}


	public static Logger getLogger() {
		return logger;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Guerrero [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", fuerza=");
		builder.append(fuerza);
		builder.append(", resistencia=");
		builder.append(resistencia);
		builder.append("]");
		return builder.toString();
	}

}
