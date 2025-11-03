package com.service.reservas.servicios.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

public class Service {

    private Long id;
    private String name;
    private String description;
    private String duration;
    private Double price;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Boolean active;

    public void updateInfoServ(String name, String description, String duration, Double price, LocalDateTime updatedAt, String updatedBy) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}
