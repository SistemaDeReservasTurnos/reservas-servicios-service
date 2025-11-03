package com.service.reservas.servicios.infraestructure.persistence;

import com.service.reservas.servicios.domain.entities.Service;
import com.service.reservas.servicios.domain.repository.IServiceRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class ServiceRepositoryPersistence implements IServiceRepository {

    private final SpringRepositoryPersistence springServicioRepositoryPersistence;

    public ServiceRepositoryPersistence(SpringRepositoryPersistence springServicioRepositoryPersistence) {
        this.springServicioRepositoryPersistence = springServicioRepositoryPersistence;
    }

    @Override
    public Optional<Service> findById(Long id) {
        return springServicioRepositoryPersistence.findById(id).map(ServiceModelMapper::toDomain);
    }

    @Override
    public Optional<Service> findDuplicateByName(String name) {
        return springServicioRepositoryPersistence.findByName(name).map(ServiceModelMapper::toDomain);

    }

    @Override
    public boolean existsByName(String name) {
        return springServicioRepositoryPersistence.existsByName(name);
    }

    @Override
    public Service save(Service service) {
        ServiceModel serviceModel = ServiceModelMapper.toModel(service);
        return ServiceModelMapper.toDomain(springServicioRepositoryPersistence.save(serviceModel));
    }

}
