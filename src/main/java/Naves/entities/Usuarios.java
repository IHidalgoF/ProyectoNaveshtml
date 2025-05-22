package Naves.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_USUARIOS")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private String usuario;
	@Column(nullable = false)
	private String contrasenya;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellidos;
	
	
	public Usuarios() {
		super();
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	@Override
	public String toString() {
		return "Usuarios [usuario=" + usuario + ", contrasenya=" + contrasenya + ", nombre=" + nombre + ", apellidos="
				+ apellidos + "]";
	}
	
	
	
	
	

}
