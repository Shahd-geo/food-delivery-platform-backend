package com.fooddelivery.Dto;

import com.fooddelivery.Entities.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;
    private Boolean isVegetarian;
    private Integer calories;

    public static MenuItemResponseDTO fromEntity(MenuItem menuItem) {
        MenuItemResponseDTO dto = new MenuItemResponseDTO();
        dto.setId(menuItem.getId());
        dto.setName(menuItem.getName());
        dto.setDescription(menuItem.getDescription());
        dto.setPrice(menuItem.getPrice());
        dto.setIsAvailable(menuItem.getIsAvailable());
        dto.setIsVegetarian(menuItem.getIsVegetarian());
        dto.setCalories(menuItem.getCalories());

        return dto;
    }
    public static List<MenuItemResponseDTO> fromEntity(
            List<MenuItem> menuItems) {

        List<MenuItemResponseDTO> dtos = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            dtos.add(fromEntity(menuItem));
        }

        return dtos;
    }
}
