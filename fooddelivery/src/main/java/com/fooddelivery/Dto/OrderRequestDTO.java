package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Order;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class OrderRequestDTO {
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer restaurantId;

    @Pattern(regexp = "PENDING|CONFIRMED|PREPARING|OUT_FOR_DELIVERY|DELIVERED|CANCELLED")
    private String status;
    private String deliveryNotes;
    @NotEmpty
    @Valid
    private List<OrderItemRequestDTO> orderItems;

    public Order toEntity() {
        Order order = new Order();
        order.setStatus(this.status);
        order.setDeliveryNotes(this.deliveryNotes);

        return order;
    }
}
