package com.service.reservas.servicios.infraestructure.persistence;

import com.service.reservas.servicios.domain.entities.Service;

public class ServiceModelMapper {

    public static ServiceModel toModel(Service service) {

        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setId(service.getId());
        serviceModel.setName(service.getName());
        serviceModel.setDescription(service.getDescription());
        serviceModel.setDuration(service.getDuration());
        serviceModel.setPrice(service.getPrice());
        serviceModel.setUpdatedAt(service.getUpdatedAt());
        serviceModel.setUpdatedBy(service.getUpdatedBy());

        return serviceModel;
    }

    public static Service toDomain(ServiceModel serviceModel) {

        Service service = new Service();
        service.setId(serviceModel.getId());
        service.setName(serviceModel.getName());
        service.setDescription(serviceModel.getDescription());
        service.setDuration(serviceModel.getDuration());
        service.setPrice(serviceModel.getPrice());
        service.setUpdatedAt(serviceModel.getUpdatedAt());
        service.setUpdatedBy(serviceModel.getUpdatedBy());

        return service;
    }
}
