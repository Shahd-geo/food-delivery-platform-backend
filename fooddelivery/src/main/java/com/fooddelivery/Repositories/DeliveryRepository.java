package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository  extends JpaRepository<Delivery,Integer> {
}
