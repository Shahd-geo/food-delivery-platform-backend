package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private MenuItem menuItem;
    @ManyToOne
    private Order order;
    @ManyToOne
    private CorporateOrder corporateOrder;
}
