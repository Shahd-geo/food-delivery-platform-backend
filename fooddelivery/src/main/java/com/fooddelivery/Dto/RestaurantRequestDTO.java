package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Restaurant;
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

    public Restaurant toEntity() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(this.name);
        restaurant.setDescription(this.description);
        restaurant.setCuisineType(this.cuisineType);
        restaurant.setOpeningTime(this.openingTime);
        restaurant.setClosingTime(this.closingTime);
        restaurant.setMinOrderAmount(this.minOrderAmount);
        restaurant.setDeliveryFee(this.deliveryFee);
        restaurant.setAcceptingOrders(this.acceptingOrders);

        return restaurant;
    }
}

