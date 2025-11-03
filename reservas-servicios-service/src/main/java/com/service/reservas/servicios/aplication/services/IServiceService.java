package com.service.reservas.servicios.aplication.services;

import com.service.reservas.servicios.aplication.dto.ServiceRequest;
import com.service.reservas.servicios.aplication.dto.ServiceResponse;

// Funciones de acuerdo a las peticiones del usuario

public interface IServiceService {

    ServiceResponse createService(ServiceRequest serviceRequest);
    ServiceResponse editService(Long id, ServiceRequest serviceRequest); //editar servicio mediante id
    void deactivateService(Long id);
    ServiceResponse findServiceById(Long id); //devuelve si la existencia o no existencia del servicio
}
