package com.Order_management_system.order_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class OrderRequest {

    @NotNull(message = "User id is required")
    private Long userId;

    @NotBlank(message = "Item is required")
    private String item;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    public OrderRequest() {
    }

    public OrderRequest(Long userId, String item, BigDecimal amount) {
        this.userId = userId;
        this.item = item;
        this.amount = amount;
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
}
