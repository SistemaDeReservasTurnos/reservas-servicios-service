package com.service.reservas.servicios.infraestructure.controller;

import com.service.reservas.servicios.aplication.dto.ServiceRequest;
import com.service.reservas.servicios.aplication.dto.ServiceResponse;
import com.service.reservas.servicios.aplication.services.ServiceService;
import com.service.reservas.servicios.domain.entities.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")

public class ServiceController {

    private final ServiceService servicioService;

    public ServiceController(ServiceService serviceService) { this.servicioService = serviceService; }


    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createService(@RequestBody ServiceRequest request) {

        ServiceResponse response = servicioService.createService(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editService(@PathVariable Long id, @RequestBody ServiceRequest serviceRequest) {

        ServiceResponse updatedService = servicioService.editService(id, serviceRequest);
        return ResponseEntity.ok(updatedService); //devuelvo el servicio actulizado
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> findServiceById(@PathVariable Long id) {

        ServiceResponse serviceResponse = servicioService.findServiceById(id);
        return  ResponseEntity.ok(serviceResponse);
    }
}
