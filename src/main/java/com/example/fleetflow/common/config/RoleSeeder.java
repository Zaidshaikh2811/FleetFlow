package com.example.fleetflow.common.config;


import com.example.fleetflow.user.entity.Role;
import com.example.fleetflow.user.enums.RoleName;
import com.example.fleetflow.user.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleSeeder {


    @Bean
    CommandLineRunner seedRoles(RoleRepository roleRepository) {
        return args -> {

            for( RoleName roleName :  RoleName.values()) {
                if(!roleRepository.existsByName(roleName)) {
                    Role role = new Role();
                    role.setName(roleName);
                    roleRepository.save(role);
                }
            }

        };
    }

}
