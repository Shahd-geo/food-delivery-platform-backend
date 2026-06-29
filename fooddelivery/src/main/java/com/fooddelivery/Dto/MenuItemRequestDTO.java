package com.fooddelivery.Dto;

import com.fooddelivery.Entities.MenuItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Double price;
    @NotNull
    private Boolean isAvailable;
    @NotNull
    private Boolean isVegetarian;
    @PositiveOrZero
    private Integer calories;


    public MenuItem toEntity() {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(this.name);
        menuItem.setDescription(this.description);
        menuItem.setPrice(this.price);
        menuItem.setIsAvailable(this.isAvailable);
        menuItem.setIsVegetarian(this.isVegetarian);
        menuItem.setCalories(this.calories);

        return menuItem;
    }
}
