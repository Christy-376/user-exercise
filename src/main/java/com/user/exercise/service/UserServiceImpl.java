package com.user.exercise.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.user.exercise.entity.User;
import com.user.exercise.pojo.UserRequest;
import com.user.exercise.pojo.UserResponse;
import com.user.exercise.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;


    // Convert User entity to UserResponse
	
    private UserResponse convertToResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.isActive());
    }

    // Convert UserRequest to User entity
    private User convertToEntity(UserRequest userRequest) {
        return new User(userRequest.getUsername(), userRequest.getPassword(), userRequest.isActive());
    }

    // Create or Update User
    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = convertToEntity(userRequest);
        User savedUser = userRepository.save(user);
        return convertToResponse(savedUser);
    }

    // Read User by ID
    @Override
    public Optional<UserResponse> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToResponse);
    }

    // Read all Users
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    // Update User
    @Override
    public Optional<UserResponse> updateUser(Long id, UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            user.setActive(userRequest.isActive());
            User updatedUser = userRepository.save(user);
            return Optional.of(convertToResponse(updatedUser));
        }
        return Optional.empty();
    }

    // Delete User by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
