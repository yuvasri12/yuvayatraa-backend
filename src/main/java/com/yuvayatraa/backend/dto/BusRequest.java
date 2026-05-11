package com.yuvayatraa.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BusRequest {

    @NotBlank(message = "Bus name is required")
    private String busName;

    @NotBlank(message = "Bus number is required")
    private String busNumber;

    @NotBlank(message = "Bus type is required")
    private String busType;

    @NotNull(message = "Total capacity is required")
    private Integer totalCapacity;

    private Boolean wifi = false;
    private Boolean charging = false;
    private Boolean water = false;
}
