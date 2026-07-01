package com.fooddelivery.Services;

import com.fooddelivery.Repositories.CustomerRepository;
import com.fooddelivery.Repositories.OrderItemRepository;
import com.fooddelivery.Repositories.OrderRepository;
import com.fooddelivery.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

}
