package com.example.fleetflow.warehouse.service.impl;


import com.example.fleetflow.common.exception.ResourceNotFoundException;
import com.example.fleetflow.warehouse.dto.request.CreateWarehouseRequest;
import com.example.fleetflow.warehouse.dto.response.WarehouseResponse;
import com.example.fleetflow.warehouse.entity.Warehouse;
import com.example.fleetflow.warehouse.mapper.WarehouseMapper;
import com.example.fleetflow.warehouse.repository.WarehouseRepository;
import com.example.fleetflow.warehouse.service.WareHouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WareHouserServiceImpl implements WareHouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    public WareHouserServiceImpl(WarehouseRepository warehouseRepository , WarehouseMapper warehouseMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;

    }

    @Override
    public WarehouseResponse createWarehouse(CreateWarehouseRequest warehouseRequest  ) {
        if (warehouseRepository.existsByCode(warehouseRequest.code())) {
            throw new IllegalArgumentException("Warehouse with code " + warehouseRequest.code() + " already exists");
        }
        Warehouse warehouse = warehouseMapper.toWarehouseEntity(warehouseRequest);
        Warehouse savedWarehouse = warehouseRepository.save(warehouse);
        return warehouseMapper.toWarehouseResponse(savedWarehouse);
    }

    @Override
    @Transactional(readOnly = true)
    public WarehouseResponse getWarehouseById(Long id) {
        return warehouseRepository.findById(id)
                .map(warehouseMapper::toWarehouseResponse)
                .orElseThrow( () -> new ResourceNotFoundException("Warehouse not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public WarehouseResponse getWarehouseByCode(String  code) {
      return  warehouseRepository.findByCode( code ).map(warehouseMapper::toWarehouseResponse)
              .orElseThrow( () -> new ResourceNotFoundException("Warehouse not found with code: " + code));
    }

    @Override
    @Transactional(readOnly = true)
    public WarehouseResponse getWarehouseByName(String name) {
        return  warehouseRepository.findByName( name ).map(warehouseMapper::toWarehouseResponse)
                .orElseThrow( () -> new ResourceNotFoundException("Warehouse not found with name: " + name));
    }

    @Override
    @Transactional(readOnly = true)
    public WarehouseResponse getWarehouseByName(String name, LocalDateTime createdAt) {
        return  warehouseRepository.findByName( name ).map(warehouseMapper::toWarehouseResponse)
                .orElseThrow( () -> new ResourceNotFoundException("Warehouse not found with name: " + name + " and createdAt: " + createdAt));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WarehouseResponse> getAllWarehouses() {
        return warehouseRepository.findAll().stream()
                .map(warehouseMapper::toWarehouseResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<WarehouseResponse> getWarehousesByCity(String city) {
        return warehouseRepository.findByCityIgnoreCase(city).stream()
                .map(warehouseMapper::toWarehouseResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<WarehouseResponse> getAllWarehouses(LocalDateTime createdAt) {
        return warehouseRepository.findAll().stream()
                .filter(warehouse -> warehouse.getCreatedAt().isEqual(createdAt))
                .map(warehouseMapper::toWarehouseResponse)
                .toList();
    }
}
