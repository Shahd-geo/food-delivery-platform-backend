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
public class Review extends BaseEntity{
    private String targetType;
    private Integer rating;
    private String comment;
    private String createdAt;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private DeliveryDriver deliveryDriver;

}
