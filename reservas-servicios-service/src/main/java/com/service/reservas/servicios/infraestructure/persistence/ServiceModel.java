package com.service.reservas.servicios.infraestructure.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor

public class ServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false, length = 50)
    private String duration;

    @Column(nullable = false, length = 50)
    private Double price;

    @Column(name = "updated_at") //fecha de edición del servicion
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")  //persona que editó el servicio
    private String updatedBy;
}
