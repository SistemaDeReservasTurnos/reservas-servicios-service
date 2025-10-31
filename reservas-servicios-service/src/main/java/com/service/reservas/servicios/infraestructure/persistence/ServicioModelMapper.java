package com.service.reservas.servicios.infraestructure.persistence;

import com.service.reservas.servicios.domain.entities.Servicio;

public class ServicioModelMapper {

    public static ServicioModel toModel(Servicio servicio) {

        ServicioModel servicioModel = new ServicioModel();
        servicioModel.setId(servicio.getId());
        servicioModel.setName(servicio.getName());
        servicioModel.setDescription(servicio.getDescription());
        servicioModel.setDuration(servicio.getDuration());
        servicioModel.setPrice(servicio.getPrice());
        servicioModel.setUpdatedAt(servicioModel.getUpdatedAt());
        servicioModel.setUpdatedBy(servicioModel.getUpdatedBy());

        return servicioModel;
    }

    public static Servicio toDomain(ServicioModel servicioModel) {

        Servicio servicio = new Servicio();
        servicio.setId(servicioModel.getId());
        servicio.setName(servicioModel.getName());
        servicio.setDescription(servicioModel.getDescription());
        servicio.setDuration(servicioModel.getDuration());
        servicio.setPrice(servicioModel.getPrice());
        servicio.setUpdateAt(servicioModel.getUpdatedAt());
        servicio.setUpdatedBy(servicioModel.getUpdatedBy());

        return servicio;
    }
}
