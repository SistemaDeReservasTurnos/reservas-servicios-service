package com.service.reservas.servicios.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface SpringRepositoryPersistence extends JpaRepository<ServiceModel, Long> {

    boolean existsByName(String name);
    Optional<ServiceModel> findByName(String name);
    List<ServiceModel> findByActiveTrue();
}
