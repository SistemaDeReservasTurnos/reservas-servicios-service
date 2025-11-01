package com.service.reservas.servicios.aplication.dto;

import com.service.reservas.servicios.domain.entities.Servicio;

import java.time.LocalDateTime;

public class ServicioMapper {

    //convertir peticion(dto) a objeto de dominio

    public static Servicio toDomain(ServicioRequest servicioRequest) {

        Servicio newServicio = new Servicio();
        newServicio.setName(servicioRequest.getName());
        newServicio.setDescription(servicioRequest.getDescription());
        newServicio.setDuration(servicioRequest.getDuration());
        newServicio.setPrice(servicioRequest.getPrice());
        newServicio.setUpdatedAt(LocalDateTime.parse(servicioRequest.getUpdatedAt()));
        newServicio.setUpdatedBy(servicioRequest.getUpdatedBy());

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
        servicioResponse.setUpdatedAt(servicio.getUpdatedAt());
        servicioResponse.setUpdatedBy(servicio.getUpdatedBy());

        return servicioResponse;

    }
}
