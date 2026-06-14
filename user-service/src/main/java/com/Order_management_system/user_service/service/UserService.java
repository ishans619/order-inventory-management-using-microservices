package com.Order_management_system.user_service.service;

import com.Order_management_system.user_service.dto.UserRequest;
import com.Order_management_system.user_service.dto.UserResponse;
import com.Order_management_system.user_service.model.User;

public interface UserService {

    public UserResponse createUser(UserRequest user);

    public UserResponse getUserById(Long id);

    public UserResponse updateUser(Long id, UserRequest user);

    public void deleteUser(Long id);
}
