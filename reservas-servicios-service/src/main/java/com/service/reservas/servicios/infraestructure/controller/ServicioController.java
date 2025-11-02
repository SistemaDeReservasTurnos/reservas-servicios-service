package com.service.reservas.servicios.infraestructure.controller;

import com.service.reservas.servicios.aplication.dto.ServicioRequest;
import com.service.reservas.servicios.aplication.dto.ServicioResponse;
import com.service.reservas.servicios.aplication.services.ServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicios") 
public class ServicioController {
 
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) { 
        this.servicioService = servicioService; 
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editServicio(@PathVariable Long id, @RequestBody ServicioRequest servicioRequest) {
        try {
            ServicioResponse updatedServicio = servicioService.editServicio(id, servicioRequest);
            return ResponseEntity.ok(updatedServicio); //devuelvo el servicio actualizado

        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> existenceServiceById(@PathVariable Long id) {
        try {
            servicioService.existenceServiceByid(id);
            return ResponseEntity.ok("Servicio existente en el sistema");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    // endpoint para la eliminación lógica del servicio
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteServicio(@PathVariable Long id, @RequestParam String updatedBy) {
        try {
            servicioService.deleteServicio(id, updatedBy);
            return ResponseEntity.ok("Servicio eliminado lógicamente por " + updatedBy);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
