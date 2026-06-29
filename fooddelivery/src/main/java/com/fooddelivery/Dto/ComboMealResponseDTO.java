package com.fooddelivery.Dto;

import com.fooddelivery.Entities.ComboMeal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboMealResponseDTO {
    private Integer id;
    private String comboName;
    private String description;
    private Double totalPrice;
    private Boolean isAvailable;

    public static ComboMealResponseDTO fromEntity(ComboMeal comboMeal) {
        ComboMealResponseDTO dto = new ComboMealResponseDTO();
        dto.setId(comboMeal.getId());
        dto.setComboName(comboMeal.getComboName());
        dto.setDescription(comboMeal.getDescription());
        dto.setTotalPrice(comboMeal.getTotalPrice());
        dto.setIsAvailable(comboMeal.getIsAvailable());

        return dto;
    }
}
