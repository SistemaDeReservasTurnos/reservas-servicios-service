package com.service.reservas.servicios.infraestructure.persistence;

import com.service.reservas.servicios.domain.entities.Servicio;

import java.time.LocalDateTime;

public class ServicioModelMapper {

    public static ServicioModel toModel(Servicio servicio) {

        ServicioModel servicioModel = new ServicioModel();
        servicioModel.setId(servicio.getId());
        servicioModel.setName(servicio.getName());
        servicioModel.setDescription(servicio.getDescription());
        servicioModel.setDuration(servicio.getDuration());
        servicioModel.setPrice(servicio.getPrice());

        return servicioModel;
    }

    public static Servicio toDomain(ServicioModel servicioModel) {

        Servicio servicio = new Servicio();
        servicio.setId(servicioModel.getId());
        servicio.setName(servicioModel.getName());
        servicio.setDescription(servicioModel.getDescription());
        servicio.setDuration(servicioModel.getDuration());
        servicio.setPrice(servicioModel.getPrice());

        return servicio;
    }
}
