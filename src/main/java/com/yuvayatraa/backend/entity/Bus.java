package com.yuvayatraa.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "buses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String busName;

    @Column(nullable = false, unique = true)
    private String busNumber;

    @Column(nullable = false)
    private String busType;

    @Column(nullable = false)
    private Integer totalCapacity;

    private Boolean wifi;
    private Boolean charging;
    private Boolean water;

    @Column(nullable = false)
    private Boolean active = true;
}