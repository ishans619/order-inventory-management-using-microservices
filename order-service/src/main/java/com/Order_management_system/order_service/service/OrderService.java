package com.Order_management_system.order_service.service;

import com.Order_management_system.order_service.dto.OrderRequest;
import com.Order_management_system.order_service.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    public OrderResponse createOrder(OrderRequest request);

    public OrderResponse getOrder(Long id);

    public List<OrderResponse> getAllOrders();
}
