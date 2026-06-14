package com.Order_management_system.order_service.controller;

import com.Order_management_system.order_service.dto.OrderRequest;
import com.Order_management_system.order_service.dto.OrderResponse;
import com.Order_management_system.order_service.service.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request){
        OrderResponse response = orderServiceImpl.createOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id){
        return new ResponseEntity<>(orderServiceImpl.getOrder(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrder(){
        return new ResponseEntity<>(orderServiceImpl.getAllOrders(), HttpStatus.OK);
    }

}
