package com.service.reservas.servicios.infraestructure.persistence;

import com.service.reservas.servicios.aplication.dto.ServicioRequest;
import com.service.reservas.servicios.domain.entities.Servicio;
import com.service.reservas.servicios.domain.repository.IServicioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServicioRepositoryPersistence implements IServicioRepository {

    private final SpringRepositoryPersistence springServicioRepositoryPersistence;

    public ServicioRepositoryPersistence(SpringRepositoryPersistence springServicioRepositoryPersistence) {
        this.springServicioRepositoryPersistence = springServicioRepositoryPersistence;
    }

    @Override
    public Optional<Servicio> findById(Long id) {
        return springServicioRepositoryPersistence.findById(id).map(ServicioModelMapper::toDomain);
    }

    @Override
    public Optional<Servicio> findDuplicateByName(String name) {
        return springServicioRepositoryPersistence.findByName(name).map(ServicioModelMapper::toDomain);
    }

    @Override
    public Servicio save(Servicio servicio) {
        ServicioModel servicioModel = ServicioModelMapper.toModel(servicio);
        return ServicioModelMapper.toDomain(springServicioRepositoryPersistence.save(servicioModel));
    }

    // Método para eliminación lógica (no borra el registro, solo lo marca como inactivo)
    @Override
    public void deleteLogic(Long id, String updatedBy) {
        springServicioRepositoryPersistence.findById(id).ifPresent(servicioModel -> {
            servicioModel.setActivo(false); // lo marcamos como inactivo
            servicioModel.setUpdatedAt(java.time.LocalDateTime.now());
            servicioModel.setUpdatedBy(updatedBy);
            springServicioRepositoryPersistence.save(servicioModel);
        });
    }
}

