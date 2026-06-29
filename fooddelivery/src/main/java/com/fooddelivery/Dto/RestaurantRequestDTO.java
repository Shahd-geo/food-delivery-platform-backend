package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String cuisineType;
    @NotBlank
    private String openingTime;
    @NotBlank
    private String closingTime;
    @PositiveOrZero
    private Double minOrderAmount;
    @PositiveOrZero
    private Double deliveryFee;
    @NotNull
    private Boolean acceptingOrders;

}
