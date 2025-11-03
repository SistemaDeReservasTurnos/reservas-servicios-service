package com.service.reservas.servicios.aplication.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceRequest {

    @NotBlank(message = "The service name is required")
    @Size(max = 100, message = "100 characters max")
    private String name;
    @NotBlank(message = "The service description is required")
    private String description;
    @NotBlank(message = "The service duration is required")
    private String duration;
    @NotNull(message = "The service price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "The price must be positive")
    private Double price;
}
