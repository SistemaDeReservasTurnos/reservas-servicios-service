package com.service.reservas.servicios.infraestructure.persistence;

import com.service.reservas.servicios.domain.entities.Service;
import com.service.reservas.servicios.domain.repository.IServiceRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Component

public class ServiceRepositoryPersistence implements IServiceRepository {

    private final SpringRepositoryPersistence springServiceRepositoryPersistence;

    public ServiceRepositoryPersistence(SpringRepositoryPersistence springServiceRepositoryPersistence) {
        this.springServiceRepositoryPersistence = springServiceRepositoryPersistence;
    }

    @Override
    public Optional<Service> findById(Long id) {
        return springServiceRepositoryPersistence.findById(id).map(ServiceModelMapper::toDomain);
    }

    @Override
    public Optional<Service> findDuplicateByName(String name) {
        return springServiceRepositoryPersistence.findByName(name).map(ServiceModelMapper::toDomain);

    }

    @Override
    public boolean existsByName(String name) {
        return springServiceRepositoryPersistence.existsByName(name);
    }

    @Override
    public Service save(Service service) {
        ServiceModel serviceModel = ServiceModelMapper.toModel(service);
        return ServiceModelMapper.toDomain(springServiceRepositoryPersistence.save(serviceModel));
    }

    @Override
    public List<Service> getAllServicesActives(){

        List<ServiceModel> serviceModel = springServiceRepositoryPersistence.findByActiveTrue();

        return serviceModel.stream()
                .map(ServiceModelMapper::toDomain)
                .collect(Collectors.toList());
    }

}
