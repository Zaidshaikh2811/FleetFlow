package com.example.fleetflow.warehouse.controller;

import com.example.fleetflow.common.response.ApiResponse;
import com.example.fleetflow.warehouse.dto.request.CreateWarehouseRequest;
import com.example.fleetflow.warehouse.dto.response.WarehouseResponse;
import com.example.fleetflow.warehouse.service.WareHouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {


    private final WareHouseService warehouseService;

    public WarehouseController(WareHouseService warehouseService) {
        this.warehouseService = warehouseService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<WarehouseResponse>> createWarehouse(@Valid @RequestBody CreateWarehouseRequest request) {
        WarehouseResponse response =  warehouseService.createWarehouse(request);
        return ResponseEntity .status(HttpStatus.CREATED) .body(ApiResponse.success(response, "Warehouse created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<WarehouseResponse>>> getWarehouseByName(  ) {
        List<WarehouseResponse> response = warehouseService.getAllWarehouses( );
        return ResponseEntity.ok(ApiResponse.success(response, "Warehouse retrieved successfully"));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<WarehouseResponse>> getWarehouses( @RequestParam(required = false) String city ) {

        if (city != null && !city.isBlank()) {
            return ResponseEntity.ok(  warehouseService.getWarehousesByCity(city) );
        }
        return ResponseEntity.ok( warehouseService.getAllWarehouses()  );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<WarehouseResponse>> getWarehouseById( @PathVariable Long id ) {
        WarehouseResponse response = warehouseService.getWarehouseById(id);
        return ResponseEntity.ok(ApiResponse.success(response, "Warehouse retrieved successfully"));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ApiResponse<WarehouseResponse>> getWarehouseByCode( @PathVariable String code ) {
        WarehouseResponse response = warehouseService.getWarehouseByCode(code);
        return ResponseEntity.ok(ApiResponse.success(response, "Warehouse retrieved successfully"));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ApiResponse<WarehouseResponse>> getWarehouseByName( @PathVariable String name ) {
        WarehouseResponse response = warehouseService.getWarehouseByName(name);
        return ResponseEntity.ok(ApiResponse.success(response, "Warehouse retrieved successfully"));
    }





}
