package com.fooddelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private String cuisineType;
    private String openingTime;
    private String closingTime;
    private Double minOrderAmount;
    private Double deliveryFee;
    private Boolean acceptingOrders;
}
