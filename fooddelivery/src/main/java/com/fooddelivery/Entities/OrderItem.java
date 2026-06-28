package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderItem extends BaseEntity{
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String specialInstructions;
}
