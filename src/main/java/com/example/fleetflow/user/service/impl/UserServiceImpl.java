package com.example.fleetflow.user.service.impl;

import com.example.fleetflow.common.exception.DuplicateResourceException;
import com.example.fleetflow.common.exception.ResourceNotFoundException;
import com.example.fleetflow.user.dto.request.CreateUserRequest;
import com.example.fleetflow.user.dto.response.UserResponse;
import com.example.fleetflow.user.entity.Role;
import com.example.fleetflow.user.entity.User;
import com.example.fleetflow.user.enums.RoleName;
import com.example.fleetflow.user.mapper.UserMapper;
import com.example.fleetflow.user.repository.RoleRepository;
import com.example.fleetflow.user.repository.UserRepository;
import com.example.fleetflow.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,  PasswordEncoder passwordEncoder , RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {

    if(userRepository.existsByEmail(userRequest.getEmail())) {
        throw new DuplicateResourceException("User with email " + userRequest.getEmail() + " already exists");
    }

    if(!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
        throw new IllegalArgumentException("Password and Confirm Password do not match");
    }

        Role customerRole = roleRepository.findByName(RoleName.CUSTOMER).orElseThrow(() -> new RuntimeException("Customer role not found"));
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User user = UserMapper.toUser(userRequest);
        user.getRoles().add(customerRole);
        User savedUser = userRepository.save(user);
        return UserMapper.toUserResponse(savedUser);

    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return UserMapper.toUserResponse(user);
    }
}
