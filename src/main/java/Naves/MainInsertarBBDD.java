package Naves;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Naves.Excepciones.NaveCompletaExcepcion;
import Naves.Excepciones.TipoErrorGuerreroExcepcion;
import Naves.entities.Guerrero;
import Naves.entities.VehiculoGuerra;

public class MainInsertarBBDD {

    public static void main(String[] args) throws NaveCompletaExcepcion, TipoErrorGuerreroExcepcion {

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();

   
        VehiculoGuerra vg = new VehiculoGuerra("Enterprise", "NaveDestructora", 4, 5);
        Guerrero[] grupo1 = {
            new Guerrero("Spock", "Terminator", 4, 6),
            new Guerrero("Kirk", "Terminator", 5, 3),
            new Guerrero("Jean-Luc", "Terminator", 5, 3),
            new Guerrero("Data", "Terminator", 5, 3),
            new Guerrero("Worf", "Terminator", 5, 3),
            new Guerrero("Beverly", "Terminator", 5, 3),
            new Guerrero("Geordi", "Terminator", 5, 3),
            new Guerrero("Riker", "Terminator", 5, 3),
            new Guerrero("Seven", "Terminator", 5, 3),
            new Guerrero("Janeway", "Terminator", 5, 3)
        };
        for (Guerrero g : grupo1) {
            g.setVehiculoguerra(vg);
            vg.embarcarGuerrero(g);
        }

     
        VehiculoGuerra vg1 = new VehiculoGuerra("Nostromo", "NaveDestructora", 6, 4);
        Guerrero[] grupo2 = {
            new Guerrero("Neo", "Terminator", 4, 6),
            new Guerrero("Trinity", "Terminator", 5, 3),
            new Guerrero("Morpheus", "Terminator", 5, 3),
            new Guerrero("Cypher", "Terminator", 5, 3),
            new Guerrero("Tank", "Terminator", 5, 3),
            new Guerrero("Dozer", "Terminator", 5, 3),
            new Guerrero("Switch", "Terminator", 5, 3),
            new Guerrero("Apoc", "Terminator", 5, 3),
            new Guerrero("Seraph", "Terminator", 5, 3),
            new Guerrero("Oracle", "Terminator", 5, 3)
        };
        for (Guerrero g : grupo2) {
            g.setVehiculoguerra(vg1);
            vg1.embarcarGuerrero(g);
        }

     
        VehiculoGuerra vg3 = new VehiculoGuerra("Panzer IV", "Tanque", 5, 5);
        Guerrero[] grupo3 = {
            new Guerrero("Rommel", "Soldado", 5, 4),
            new Guerrero("Manstein", "Soldado", 4, 5),
            new Guerrero("Guderian", "Soldado", 4, 4),
            new Guerrero("Bayerlein", "Soldado", 3, 6),
            new Guerrero("Hausser", "Soldado", 5, 3),
            new Guerrero("Model", "Soldado", 4, 5),
            new Guerrero("Dietrich", "Soldado", 5, 4),
            new Guerrero("Paulus", "Soldado", 4, 5),
            new Guerrero("Kleist", "Soldado", 4, 4),
            new Guerrero("Hoth", "Soldado", 3, 6)
        };
        for (Guerrero g : grupo3) {
            g.setVehiculoguerra(vg3);
            vg3.embarcarGuerrero(g);
        }

      
        VehiculoGuerra vg4 = new VehiculoGuerra("Sherman M4", "Tanque", 5, 5);
        Guerrero[] grupo4 = {
            new Guerrero("Patton", "Soldado", 5, 4),
            new Guerrero("Bradley", "Soldado", 4, 5),
            new Guerrero("Eisenhower", "Soldado", 4, 4),
            new Guerrero("MacArthur", "Soldado", 3, 6),
            new Guerrero("Montgomery", "Soldado", 5, 3),
            new Guerrero("Churchill", "Soldado", 4, 5),
            new Guerrero("Clark", "Soldado", 5, 4),
            new Guerrero("Ridgeway", "Soldado", 4, 5),
            new Guerrero("Hodges", "Soldado", 4, 4),
            new Guerrero("Simpson", "Soldado", 3, 6)
        };
        for (Guerrero g : grupo4) {
            g.setVehiculoguerra(vg4);
            vg4.embarcarGuerrero(g);
        }

        session.save(vg);
        session.save(vg1);
        session.save(vg3);
        session.save(vg4);

        tx.commit();
    }
}
