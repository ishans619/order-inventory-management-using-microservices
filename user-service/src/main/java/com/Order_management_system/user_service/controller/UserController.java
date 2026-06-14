package com.Order_management_system.user_service.controller;

import com.Order_management_system.user_service.dto.UserRequest;
import com.Order_management_system.user_service.dto.UserResponse;
import com.Order_management_system.user_service.model.User;
import com.Order_management_system.user_service.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userR){
        return new ResponseEntity<>(userServiceImpl.createUser(userR), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@Valid @PathVariable Long id, @RequestBody UserRequest userR){
        return new ResponseEntity<>(userServiceImpl.updateUser(id, userR), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userServiceImpl.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
