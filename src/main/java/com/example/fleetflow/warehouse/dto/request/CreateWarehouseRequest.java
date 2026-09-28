package com.example.fleetflow.warehouse.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateWarehouseRequest(
        @NotBlank(message = "Warehouse name is required")
        String name,
        @NotBlank(message = "Warehouse code is required")
        @Size(min = 3, max = 10, message = "Warehouse code must be between 3 and 10 characters")
        String code,
        @NotBlank(message = "Warehouse address is required")
        String address,
        @NotBlank(message = "Warehouse city is required")
        String city,
        @NotBlank(message = "Warehouse state is required")
        String state,
        @NotBlank(message = "Warehouse country is required")
        String country,
        @NotBlank(message = "Warehouse postal code is required")
        String postalCode,
        @NotBlank(message = "Warehouse phone is required")
        @Size(max = 15)
        String phone,
        @NotBlank(message = "Warehouse capacity is required")
        @Positive(message = "Warehouse capacity must be a positive number")
        Integer capacity
) {
}
