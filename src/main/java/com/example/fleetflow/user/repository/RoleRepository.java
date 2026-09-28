package com.example.fleetflow.user.repository;

import com.example.fleetflow.user.entity.Role;
import com.example.fleetflow.user.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);

    boolean existsByName(RoleName roleName);
}
