package com.user.exercise.service;

import java.util.List;
import java.util.Optional;

import com.user.exercise.pojo.UserRequest;
import com.user.exercise.pojo.UserResponse;

public interface UserService {

	public UserResponse saveUser(UserRequest userRequest);

	public Optional<UserResponse> getUserById(Long id);

	public List<UserResponse> getAllUsers();

	public Optional<UserResponse> updateUser(Long id, UserRequest userRequest);

	public void deleteUser(Long id);

}
