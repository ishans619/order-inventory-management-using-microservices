package com.Order_management_system.order_service.dto;

import java.math.BigDecimal;

public class OrderResponse {

    private Long id;
    private Long userId;
    private String item;
    private BigDecimal amount;
    private String userName;
    private String userEmail;

    public OrderResponse() {
    }

    public OrderResponse(Long id, Long userId, String item, BigDecimal amount, String userName, String userEmail) {
        this.id = id;
        this.userId = userId;
        this.item = item;
        this.amount = amount;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
