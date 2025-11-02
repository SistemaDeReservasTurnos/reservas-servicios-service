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

//    La idea es que estos campos no deben estar aqui
    private String updatedAt;
    private String updatedBy;
}
