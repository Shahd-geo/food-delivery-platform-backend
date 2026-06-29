package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    // IF ONE RESTURENT
    public static RestaurantResponseDTO fromEntity(Restaurant restaurant) {
        RestaurantResponseDTO dto = new RestaurantResponseDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setDescription(restaurant.getDescription());
        dto.setCuisineType(restaurant.getCuisineType());
        dto.setOpeningTime(restaurant.getOpeningTime());
        dto.setClosingTime(restaurant.getClosingTime());
        dto.setMinOrderAmount(restaurant.getMinOrderAmount());
        dto.setDeliveryFee(restaurant.getDeliveryFee());
        dto.setAcceptingOrders(restaurant.getAcceptingOrders());

        return dto;
    }

    //CONVERT LIST OF RESTURENT
    public static List<RestaurantResponseDTO> fromEntity(
            List<Restaurant> restaurants) {
        List<RestaurantResponseDTO> dtos = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            dtos.add(fromEntity(restaurant));
        }

        return dtos;
    }
}
