package com.service.reservas.servicios.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceRequest {

    private String name;
    private String description;
    private String duration;
    private Double price;
}
