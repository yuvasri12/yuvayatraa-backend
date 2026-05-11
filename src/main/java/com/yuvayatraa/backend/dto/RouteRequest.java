package com.yuvayatraa.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RouteRequest {

    @NotBlank(message = "Source city is required")
    private String sourceCity;

    @NotBlank(message = "Destination city is required")
    private String destinationCity;

    @NotBlank(message = "Departure time is required")
    private String departureTime;

    @NotBlank(message = "Arrival time is required")
    private String arrivalTime;

    @NotNull(message = "Base fare is required")
    private Double baseFare;

    private Boolean daily = false;
    private Boolean monFri = false;
    private Boolean weekends = false;

    private Long busId;
}