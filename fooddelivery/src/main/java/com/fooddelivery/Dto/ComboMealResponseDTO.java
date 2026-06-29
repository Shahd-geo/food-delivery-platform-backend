package com.fooddelivery.Dto;

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
}
