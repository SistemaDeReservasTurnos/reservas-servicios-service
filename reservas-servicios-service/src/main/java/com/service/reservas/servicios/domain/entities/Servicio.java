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
    private LocalDateTime updateAt;
    private String updatedBy;
}
