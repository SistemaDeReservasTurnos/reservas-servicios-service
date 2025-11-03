package com.service.reservas.servicios.infraestructure.controller;

import com.service.reservas.servicios.aplication.dto.ServiceRequest;
import com.service.reservas.servicios.aplication.dto.ServiceResponse;
import com.service.reservas.servicios.aplication.services.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/services")

public class ServiceController {

    private final ServiceService servicioService;

    public ServiceController(ServiceService serviceService) { this.servicioService = serviceService; }


    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createService(@Valid @RequestBody ServiceRequest request) {

        ServiceResponse response = servicioService.createService(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ServiceResponse> editService(@PathVariable Long id, @Valid @RequestBody ServiceRequest serviceRequest) {

        ServiceResponse updatedService = servicioService.editService(id, serviceRequest);
        return ResponseEntity.ok(updatedService); //devuelvo el servicio actualizado
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> findServiceById(@PathVariable Long id) {

        ServiceResponse serviceResponse = servicioService.findServiceById(id);
        return  ResponseEntity.ok(serviceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateService(@PathVariable Long id) {

        servicioService.deactivateService(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ServiceResponse>> getAllServices() {
        List<ServiceResponse> servicios = servicioService.getAllServices();
        return  ResponseEntity.ok(servicios);
    }
}
