package com.service.reservas.servicios.domain.repository;

import com.service.reservas.servicios.aplication.dto.ServicioRequest;
import com.service.reservas.servicios.aplication.dto.ServicioResponse;
import com.service.reservas.servicios.domain.entities.Servicio;
import com.service.reservas.servicios.infraestructure.persistence.ServicioModel;

import java.util.Optional;

public interface IServicioRepository {

    Optional<Servicio> findById(Long id);
    Optional<Servicio> findDuplicateByName(String name); //buscar si hay un duplicado de servicio con el nombre
    Servicio save(Servicio servicio);
}
