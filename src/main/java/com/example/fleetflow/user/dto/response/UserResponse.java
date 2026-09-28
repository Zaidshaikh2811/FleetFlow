package com.example.fleetflow.user.dto.response;

import com.example.fleetflow.user.entity.Role;
import com.example.fleetflow.user.enums.RoleName;
import com.example.fleetflow.user.enums.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;


@Data
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserStatus status;
    private Set<RoleName> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
