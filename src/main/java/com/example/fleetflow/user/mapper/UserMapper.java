package com.example.fleetflow.user.mapper;

import com.example.fleetflow.user.dto.request.CreateUserRequest;
import com.example.fleetflow.user.dto.response.UserResponse;
import com.example.fleetflow.user.entity.Role;
import com.example.fleetflow.user.entity.User;
import com.example.fleetflow.user.enums.RoleName;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {




    public static UserResponse toUserResponse(User user) {
        if (user == null) {
            return null;
        }

        Set<RoleName> roleNames = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setStatus(user.getStatus());
        userResponse.setRoles(roleNames);
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }

    public static User toUser(CreateUserRequest user) {
        if (user == null) {
            return null;
        }

        User userEntity = new User();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setPassword( user.getPassword() );


        return userEntity;
    }

}
