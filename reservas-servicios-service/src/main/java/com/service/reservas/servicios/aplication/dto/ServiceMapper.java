package com.service.reservas.servicios.aplication.dto;

import com.service.reservas.servicios.domain.entities.Service;

public class ServiceMapper {

    //convertir peticion(dto) a objeto de dominio

    public static Service toDomain(ServiceRequest serviceRequest) {

        Service newService = new Service();
        newService.setName(serviceRequest.getName());
        newService.setDescription(serviceRequest.getDescription());
        newService.setDuration(serviceRequest.getDuration());
        newService.setPrice(serviceRequest.getPrice());
//        newService.setUpdatedAt(LocalDateTime.parse(servicioRequest.getUpdatedAt()));
//        newService.setUpdatedBy(servicioRequest.getUpdatedBy());

        return newService;

    }

    // dto de respuesta

    public static ServiceResponse toResponse(Service service) {

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setId(service.getId());
        serviceResponse.setName(service.getName());
        serviceResponse.setDescription(service.getDescription());
        serviceResponse.setDuration(service.getDuration());
        serviceResponse.setPrice(service.getPrice());
        serviceResponse.setUpdatedAt(service.getUpdatedAt());
        serviceResponse.setUpdatedBy(service.getUpdatedBy());

        return serviceResponse;

    }
}
