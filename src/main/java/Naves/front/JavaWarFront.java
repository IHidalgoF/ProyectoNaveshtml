package Naves.front;

import java.util.List;

import Naves.utilidades.Utilidades;



public class JavaWarFront {

    private GuerraService servicio;
    private String nombreBatalla;

    public JavaWarFront (String nombreCarrera){
        this.servicio = new GuerraService();
        this.nombreBatalla = nombreBatalla;
    }

    public void iniciaMenuCarrera() {
        System.out.println("Bienvenido a la carrera "+ this.nombreBatalla);
        int opcion;
        do {
            Utilidades.pintaMenu(new String[]{"1. Insertar nueva Nave ",
                "2. Insertar nueva Guerreros","3. MostrarNave",
                "4. IniciarBatalla","5. Eliminar Nave",
                "6. Mostrar caballos por nacionalidad Jinete",
                "7. Salir"} , "");
            opcion = Utilidades.pideDatoNumerico("Elige una opción: ");
            
            switch (opcion) {
                case 1:
                    crearNave();
                    break;
                case 2:
                	crearGuerero();
                    break;
                case 3:
                    mostrarNaves();
                    break;
                case 4:
                    iniciarBatalla();
                    break;
                case 5:
                    eliminarNave();
                    break;
                case 6:
                    System.out.println("Aaaadios!");;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 6);

    }

    private NaveDTO crearNave () {
       
        String nombreNave = Utilidades.pideDatoCadena("Nombre: ");
        String tipoNave = Utilidades.pideDatoCadena("Tipo: ");
        int ataque = Utilidades.pideDatoNumerico("Ataque: ");
        int defensa = Utilidades.pideDatoNumerico("Defensa: ");

        NaveDTO caballoDto = new NaveDTO(nombreNave, tipoNave, ataque, defensa);

        servicio.insertarNave(NaveDto);
        return NaveDto;
    }
    
    private NaveDTO crearGuerero () {
        
    	String nombreGuerrero = Utilidades.pideDatoCadena("Nombre: ");
        String tipoGuerrero = Utilidades.pideDatoCadena("Tipo: ");
        int fuerza = Utilidades.pideDatoNumerico("Fuerza: ");
        int resistencia = Utilidades.pideDatoNumerico("Resistencia: ");

        NaveDTO caballoDto = new NaveDTO(nombreGuerrero, tipoGuerrero, fuerza, resistencia);

        servicio.insertarNave(NaveDto);
        return NaveDto;
    }

    private void mostrarNaves (){
        List<NaveDTO> Naves = servicio.obtenerNaves();
        for (NaveDTO caballoDTO : caballos) {
            System.out.println(caballoDTO.getNombre());
            System.out.println(caballoDTO.getNombreJinete());
        }
    }

    private  void iniciarBatalla (){
        servicio.simularBatalla(servicio.obtenerNaves());
    }

    private void eliminarNave (){
        //mostrarCaballos();
        int id = Utilidades.pideDatoNumerico("Introduce el id de la Nave a eliminar");
        servicio.eliminarNave(id);
        System.out.println("Nave con id "+id + " borrado");
    }
}
