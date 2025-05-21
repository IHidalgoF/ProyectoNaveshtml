package Naves.services;

import Naves.dao.GuerreroDAO;
import Naves.dao.VehiculoGuerraDAO;
import Naves.dto.GuerreroDTO;
import Naves.dto.VehiculoGuerraDTO;
import Naves.entities.Guerrero;
import Naves.entities.VehiculoGuerra;

import java.util.List;

public class NaveService {

    private GuerreroDAO guerreroDAO = new GuerreroDAO();
    private VehiculoGuerraDAO vehiculoGuerraDAO = new VehiculoGuerraDAO();

    public void guardarVehiculoYGuerreros(VehiculoGuerraDTO vehiculoDTO) {
        // Convertir DTO a entidades
        VehiculoGuerra vehiculo = new VehiculoGuerra(vehiculoDTO.getNombre(), vehiculoDTO.getTipo(), 
                                                     vehiculoDTO.getAtaque(), vehiculoDTO.getDefensa());

        // Guardar el VehiculoGuerra
        vehiculoGuerraDAO.save(vehiculo);

        // Convertir los guerreros y guardarlos
        for (GuerreroDTO guerreroDTO : vehiculoDTO.getGuerreros()) {
            Guerrero guerrero = new Guerrero(guerreroDTO.getNombre(), guerreroDTO.getTipo(),
                                             guerreroDTO.getAtaque(), guerreroDTO.getDefensa());
            guerrero.setVehiculoguerra(vehiculo); // Relación con el vehículo
            guerreroDAO.save(guerrero); // Guardar guerrero
        }
    }
}
