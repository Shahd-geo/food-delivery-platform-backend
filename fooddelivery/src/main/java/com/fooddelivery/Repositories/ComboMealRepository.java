package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.ComboMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboMealRepository extends JpaRepository<ComboMeal, Integer> {
}
