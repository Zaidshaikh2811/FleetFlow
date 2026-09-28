package com.example.fleetflow.warehouse.service;


import com.example.fleetflow.warehouse.dto.request.CreateWarehouseRequest;
import com.example.fleetflow.warehouse.dto.response.WarehouseResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface WareHouseService {

    WarehouseResponse createWarehouse(CreateWarehouseRequest warehouseResponse);
    WarehouseResponse getWarehouseById(Long id);
    WarehouseResponse getWarehouseByCode(String  code);
    WarehouseResponse getWarehouseByName(String name);
    WarehouseResponse getWarehouseByName(String name, LocalDateTime createdAt);
    List<WarehouseResponse> getAllWarehouses();
    List<WarehouseResponse> getWarehousesByCity(String city);
    List<WarehouseResponse> getAllWarehouses(LocalDateTime createdAt);
}
