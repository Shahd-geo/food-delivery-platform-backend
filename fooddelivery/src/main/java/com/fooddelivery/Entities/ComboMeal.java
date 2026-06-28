package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboMeal extends BaseEntity{
    private String comboName;
    private String description;
    private Double totalPrice;
    private Boolean isAvailable;
}
