package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class OrderItemRequestDTO {
    @Positive
    private Integer quantity;
    @PositiveOrZero
    private Double unitPrice;
    @PositiveOrZero
    private Double totalPrice;
    private String specialInstructions;
    @NotNull
    private Integer menuItemId;
}
