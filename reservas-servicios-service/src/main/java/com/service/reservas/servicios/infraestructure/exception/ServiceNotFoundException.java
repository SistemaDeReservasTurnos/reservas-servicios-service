package com.service.reservas.servicios.infraestructure.exception;

public class ServiceNotFoundException extends RuntimeException {

    public ServiceNotFoundException(Long id) {
        super("El servicio con ID " + id + " no fue encontrado en el sistema.");
    }
}