package com.example.fleetflow.user.controller;

import com.example.fleetflow.common.response.ApiResponse;
import com.example.fleetflow.user.dto.request.CreateUserRequest;
import com.example.fleetflow.user.dto.response.UserResponse;
import com.example.fleetflow.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<String>> healthCheck() {
        return ResponseEntity.ok(ApiResponse.success("User service is up and running"));
    }

    @PostMapping
    public  ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(userResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(userResponse));
    }

}
