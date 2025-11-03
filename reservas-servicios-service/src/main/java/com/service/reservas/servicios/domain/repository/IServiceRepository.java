package com.service.reservas.servicios.domain.repository;


import com.service.reservas.servicios.domain.entities.Service;

import java.util.Optional;


//repository solo debe saber de la entidad dominio (no de aplication)

public interface IServiceRepository {

    Optional<Service> findById(Long id);
    Optional<Service> findDuplicateByName(String name); //buscar si hay un duplicado de servicio con el nombre
    boolean existsByName(String name);
    Service save(Service service);
}
