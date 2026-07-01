package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOwnerRepository  extends JpaRepository<RestaurantOwner, Integer> {
}
