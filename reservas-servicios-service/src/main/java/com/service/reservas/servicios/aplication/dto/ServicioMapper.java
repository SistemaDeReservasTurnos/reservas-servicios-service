package com.service.reservas.servicios.aplication.dto;

import com.service.reservas.servicios.domain.entities.Servicio;

public class ServicioMapper {

    //convertir peticion(dto) a objeto de dominio

    public static Servicio toDomain(ServicioRequest servicioRequest) {

        Servicio newServicio = new Servicio();
        newServicio.setName(servicioRequest.getName());
        newServicio.setDescription(servicioRequest.getDescription());
        newServicio.setDuration(servicioRequest.getDuration());
        newServicio.setPrice(servicioRequest.getPrice());

        return newServicio;

    }

    // dto de respuesta

    public static ServicioResponse toResponse(Servicio servicio) {

        ServicioResponse servicioResponse = new ServicioResponse();
        servicioResponse.setId(servicio.getId());
        servicioResponse.setName(servicio.getName());
        servicioResponse.setDescription(servicio.getDescription());
        servicioResponse.setDuration(servicio.getDuration());
        servicioResponse.setPrice(servicio.getPrice());

        return servicioResponse;

    }
}
