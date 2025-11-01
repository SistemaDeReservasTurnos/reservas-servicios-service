package com.service.reservas.servicios.aplication.services;

import com.service.reservas.servicios.aplication.dto.ServicioRequest;
import com.service.reservas.servicios.aplication.dto.ServicioResponse;
import com.service.reservas.servicios.domain.entities.Servicio;

// Funciones de acuerdo a las peticiones del usario

public interface IServicioService {

    ServicioResponse createServicio(ServicioRequest servicioRequest);
    ServicioResponse editServicio(Long id, ServicioRequest servicioRequest); //editar servicio mediante id
    Servicio existenceServiceByid(Long id); //devuelve si la existencia o no existencia del servicio

}
