package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository  extends JpaRepository<MenuItem, Integer> {
    @Query("""
       SELECT m
       FROM MenuItem m
       WHERE m.restaurant.id = :restaurantId
       AND m.isActive = true
       """)
    List<MenuItem> findByRestaurantId(@Param("restaurantId") Integer restaurantId);

    @Query("""
       SELECT m
       FROM MenuItem m
       WHERE m.restaurant.id = :restaurantId
       AND m.isAvailable = true
       AND m.isActive = true
       """)
    List<MenuItem> findByRestaurantIdAndIsAvailableTrue(@Param("restaurantId") Integer restaurantId);

    @Query("""
       SELECT m
       FROM MenuItem m
       WHERE m.isVegetarian = true
       AND m.isActive = true
       """)
    List<MenuItem> findByIsVegetarianTrue();

    @Query("""
       SELECT m
       FROM MenuItem m
       WHERE m.price BETWEEN :min AND :max
       AND m.isActive = true
       """)
    List<MenuItem> findByPriceBetween(@Param("min") Double min, @Param("max") Double max);
}
