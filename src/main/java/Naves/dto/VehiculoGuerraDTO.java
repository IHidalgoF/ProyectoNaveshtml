package Naves.dto;

import java.util.List;

public class VehiculoGuerraDTO {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private List<GuerreroDTO> guerreros;

    // Constructor
    public VehiculoGuerraDTO(String nombre, String tipo, int ataque, int defensa, List<GuerreroDTO> guerreros) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.guerreros = guerreros;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    public List<GuerreroDTO> getGuerreros() { return guerreros; }
    public void setGuerreros(List<GuerreroDTO> guerreros) { this.guerreros = guerreros; }
}

