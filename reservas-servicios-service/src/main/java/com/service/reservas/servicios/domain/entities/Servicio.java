package com.service.reservas.servicios.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

public class Servicio {

    private Long id;
    private String name;
    private String description;
    private String duration;
    private Double price;
    private LocalDateTime updatedAt;
    private String updatedBy;


    //falta active

    public void updateInfoServ(String name, String description, String duration, Double price) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
    }
}
