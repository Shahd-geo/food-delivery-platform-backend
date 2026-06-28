package com.fooddelivery.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends  BaseEntity {
    private String orderCode;
    private LocalDateTime orderDate;
    private String status;
    private Double subtotal;
    private Double deliveryFee;
    private Double discountAmount;
    private Double totalAmount;
    private String deliveryNotes;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Restaurant restaurant;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    @OneToOne(mappedBy = "order")
    private Delivery delivery;
    @OneToOne(mappedBy = "order")
    private Payment payment;
}