package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.Customer;
import com.fooddelivery.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer> {
}
