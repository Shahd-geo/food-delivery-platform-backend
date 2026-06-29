package com.fooddelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {
    private Integer id;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String specialInstructions;
}
