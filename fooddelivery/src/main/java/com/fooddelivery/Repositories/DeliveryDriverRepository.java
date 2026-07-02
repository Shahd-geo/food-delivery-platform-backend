package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Integer> {
}
