package com.fooddelivery.Dto;

import com.fooddelivery.Entities.OrderItem;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public OrderItem toEntity() {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(this.quantity);
        orderItem.setUnitPrice(this.unitPrice);
        orderItem.setTotalPrice(this.totalPrice);
        orderItem.setSpecialInstructions(this.specialInstructions);
        return orderItem;
    }
}
