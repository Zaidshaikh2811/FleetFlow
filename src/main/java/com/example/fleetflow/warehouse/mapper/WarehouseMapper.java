package com.example.fleetflow.warehouse.mapper;

import com.example.fleetflow.warehouse.dto.request.CreateWarehouseRequest;
import com.example.fleetflow.warehouse.dto.response.WarehouseResponse;
import com.example.fleetflow.warehouse.entity.Warehouse;
import org.springframework.stereotype.Component;


@Component
public final class WarehouseMapper {

    private WarehouseMapper() {
        // Private constructor to prevent instantiation
    }

    public WarehouseResponse toWarehouseResponse(Warehouse warehouse) {
        return new WarehouseResponse(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getCode(),
                warehouse.getAddress(),
                warehouse.getCity(),
                warehouse.getState(),
                warehouse.getCountry(),
                warehouse.getPostalCode(),
                warehouse.getPhone(),
                warehouse.getCapacity(),
                warehouse.getStatus(),
                warehouse.getCreatedAt(),
                warehouse.getUpdatedAt()
        );
    }



    public Warehouse toWarehouseEntity(CreateWarehouseRequest warehouseResponse) {
        Warehouse warehouse = new Warehouse();

        warehouse.setName(warehouseResponse.name());
        warehouse.setCode(warehouseResponse.code());
        warehouse.setAddress(warehouseResponse.address());
        warehouse.setCity(warehouseResponse.city());
        warehouse.setState(warehouseResponse.state());
        warehouse.setCountry(warehouseResponse.country());
        warehouse.setPostalCode(warehouseResponse.postalCode());
        warehouse.setPhone(warehouseResponse.phone());
        warehouse.setCapacity(warehouseResponse.capacity());
        return warehouse;

    }
}
