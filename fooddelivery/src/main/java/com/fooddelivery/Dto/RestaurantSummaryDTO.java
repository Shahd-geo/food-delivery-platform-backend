package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantSummaryDTO {
    private Integer id;
    private String name;
    public static RestaurantSummaryDTO fromEntity(Restaurant restaurant) {

        RestaurantSummaryDTO dto = new RestaurantSummaryDTO();

        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());

        return dto;
    }
}
