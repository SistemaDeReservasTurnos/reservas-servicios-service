package com.service.reservas.servicios.aplication.services;

import com.service.reservas.servicios.aplication.dto.ServiceMapper;
import com.service.reservas.servicios.aplication.dto.ServiceRequest;
import com.service.reservas.servicios.aplication.dto.ServiceResponse;
import com.service.reservas.servicios.domain.entities.Service;
import com.service.reservas.servicios.infraestructure.exception.ServiceNotFoundException;
import com.service.reservas.servicios.domain.repository.IServiceRepository;
import org.springframework.dao.DuplicateKeyException;

import java.time.LocalDateTime;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    private final IServiceRepository servicioRepository;

    //Manejo temporal del valor fijo para usuario.
    private static final String AUDIT_USER_ID = "USER_AUDIT_DEV";

    public ServiceService(IServiceRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    private String normalizeServiceName(String name) {
        name = name.trim();
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @Override
    public ServiceResponse createService(ServiceRequest serviceRequest) {

        String normalized = normalizeServiceName(serviceRequest.getName());
        serviceRequest.setName(normalized);

        if (servicioRepository.existsByName(serviceRequest.getName())){
            throw new DuplicateKeyException("A service with the name already exists: " + serviceRequest.getName());
        }

        Service newService = ServiceMapper.toDomain(serviceRequest);

        newService.setActive(true);
        LocalDateTime now = LocalDateTime.now();
        newService.setUpdatedAt(now);
        newService.setUpdatedBy(AUDIT_USER_ID);

        Service savedService = servicioRepository.save(newService);
        return ServiceMapper.toResponse(savedService);
}


    @Override
    public ServiceResponse editService(Long id, ServiceRequest serviceRequest) {

        String normalized = normalizeServiceName(serviceRequest.getName());
        serviceRequest.setName(normalized);

        Service existsService = findServiceByIdInternal(id);
        Optional<Service> duplicated = servicioRepository.findDuplicateByName(serviceRequest.getName());
        if (duplicated.isPresent()) {
            Service idFound = duplicated.get();

            if (!existsService.getId().equals(idFound.getId())) {
                throw new DuplicateKeyException("Ya existe un servicio con ese nombre");
            }
        }

        existsService.updateInfoServ(
                serviceRequest.getName(),
                serviceRequest.getDescription(),
                serviceRequest.getDuration(),
                serviceRequest.getPrice(),
                LocalDateTime.now(),
                AUDIT_USER_ID
        );

        Service updateService = servicioRepository.save(existsService);
        return ServiceMapper.toResponse(updateService);
    }

    @Override
    public ServiceResponse findServiceById(Long id) {
        return ServiceMapper.toResponse(findServiceByIdInternal(id));
    }

    private Service findServiceByIdInternal(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException(id));
    }
}