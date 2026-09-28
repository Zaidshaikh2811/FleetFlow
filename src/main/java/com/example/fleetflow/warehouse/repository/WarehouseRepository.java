package com.example.fleetflow.warehouse.repository;

import com.example.fleetflow.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Optional<Warehouse> findByCode(String code);
    Optional<Warehouse>  findByName(String name);
    boolean existsByCode(String  code);
    List<Warehouse> findByCityIgnoreCase(String city);

}
