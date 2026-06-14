package com.Order_management_system.user_service.service.impl;

import com.Order_management_system.user_service.dto.UserRequest;
import com.Order_management_system.user_service.dto.UserResponse;
import com.Order_management_system.user_service.model.User;
import com.Order_management_system.user_service.repository.UserRepository;
import com.Order_management_system.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest userR) {
        User user = new User();
        user.setName(userR.getName());
        user.setEmail(userR.getEmail());

        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).get();

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userR) {
        User user = userRepository.findById(id).get();
        user.setName(userR.getName());
        user.setEmail(userR.getEmail());

        User updatedUser = userRepository.save(user);

        UserResponse response = new UserResponse();
        response.setId(updatedUser.getId());
        response.setName(updatedUser.getName());
        response.setEmail(updatedUser.getEmail());

        return response;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
