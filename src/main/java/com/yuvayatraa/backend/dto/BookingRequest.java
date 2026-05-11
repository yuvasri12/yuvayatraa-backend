
package com.yuvayatraa.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequest {

    @NotNull(message = "Route ID is required")
    private Long routeId;

    @NotBlank(message = "Seats are required")
    private String seats;

    @NotNull(message = "Total amount is required")
    private Double totalAmount;
}