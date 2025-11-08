package com.service.reservas.servicios.aplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceResponse {

    private Long id;
    private String name;
    private String description;
    private LocalTime duration;
    private Double price;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Boolean active;
}
