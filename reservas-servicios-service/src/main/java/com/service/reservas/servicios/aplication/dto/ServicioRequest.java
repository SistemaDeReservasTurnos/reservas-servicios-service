package com.service.reservas.servicios.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServicioRequest {

    private String name;
    private String description;
    private String duration;
    private Double price;
}
