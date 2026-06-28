package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem extends BaseEntity {
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;
    private Boolean isVegetarian;
    private Integer calories;
    @ManyToOne
    private Restaurant restaurant;
    @OneToMany(mappedBy = "menuItem")
    private List<OrderItem> orderItems;
    @ManyToMany
    private List<ComboMeal> comboMeals;
}
