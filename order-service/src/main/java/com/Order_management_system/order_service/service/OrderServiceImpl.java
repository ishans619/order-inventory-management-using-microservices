package com.Order_management_system.order_service.service;

import com.Order_management_system.order_service.dto.OrderRequest;
import com.Order_management_system.order_service.dto.OrderResponse;
import com.Order_management_system.order_service.dto.UserDto;
import com.Order_management_system.order_service.exception.ExternalServiceException;
import com.Order_management_system.order_service.exception.OrderNotFoundException;
import com.Order_management_system.order_service.model.Order;
import com.Order_management_system.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;
    @Value("${user.service.base-url}")
    String userServiceBaseUrl;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        UserDto user = fetchUser(request.getUserId());

        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setItem(request.getItem());
        order.setAmount(request.getAmount());

        Order saved = orderRepository.save(order);
        return toResponse(saved, user);
    }

    @Override
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        UserDto user = fetchUser(order.getUserId());
        return toResponse(order, user);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> {
                    UserDto user = fetchUser(order.getUserId());
                    return toResponse(order, user);
                })
                .collect(Collectors.toList());
    }

    private UserDto fetchUser(Long userId){
        try{
            String url = userServiceBaseUrl + "/" + userId;
            return restTemplate.getForObject(url, UserDto.class);
        }catch(RestClientException ex){
            throw new ExternalServiceException("Failed to call User Service:" + ex.getMessage());
        }
    }

    private OrderResponse toResponse(Order order, UserDto user){
        String userName = user != null ? user.getName() : null;
        String userEmail = user != null ? user.getEmail() : null;

        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getItem(),
                order.getAmount(),
                userName,
                userEmail
        );
    }
}
