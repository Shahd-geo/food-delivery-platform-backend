package com.fooddelivery.Dto;

import com.fooddelivery.Entities.ComboMeal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboMealRequestDTO {
    @NotBlank
    private String comboName;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Double totalPrice;
    @NotNull
    private Boolean isAvailable;

    public ComboMeal toEntity() {
        ComboMeal comboMeal = new ComboMeal();
        comboMeal.setComboName(this.comboName);
        comboMeal.setDescription(this.description);
        comboMeal.setTotalPrice(this.totalPrice);
        comboMeal.setIsAvailable(this.isAvailable);

        return comboMeal;
    }
}
