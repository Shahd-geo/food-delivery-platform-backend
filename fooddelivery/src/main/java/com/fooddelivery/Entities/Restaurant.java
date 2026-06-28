package com.fooddelivery.Entities;

import jakarta.persistence.Entity;

@Entity
public class Restaurant extends BaseEntity{

    private String name;
    private String description;
    private String cuisineType;
    private String openingTime;
    private String closingTime;
    private Double minOrderAmount;
    private Double deliveryFee;
    private Boolean acceptingOrders;
}

