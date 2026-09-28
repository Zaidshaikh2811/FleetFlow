package com.example.fleetflow.user.service;

import com.example.fleetflow.user.dto.request.CreateUserRequest;
import com.example.fleetflow.user.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse createUser(CreateUserRequest userRequest);

    UserResponse getUserById(Long id);
}
