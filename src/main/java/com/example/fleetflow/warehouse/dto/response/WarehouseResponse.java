package com.example.fleetflow.warehouse.dto.response;

import com.example.fleetflow.warehouse.enums.WarehouseStatus;

import java.time.LocalDateTime;

public record WarehouseResponse(Long id,

                                String name,

                                String code,

                                String address,

                                String city,

                                String state,

                                String country,

                                String postalCode,

                                String phone,

                                Integer capacity,

                                WarehouseStatus status,

                                LocalDateTime createdAt,

                                LocalDateTime updatedAt) {
}
