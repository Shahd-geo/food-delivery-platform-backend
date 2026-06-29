package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
