package com.fooddelivery.Services;

import com.fooddelivery.Repositories.CustomerRepository;
import com.fooddelivery.Repositories.DeliveryDriverRepository;
import com.fooddelivery.Repositories.RestaurantRepository;
import com.fooddelivery.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DeliveryDriverRepository deliveryDriverRepository;
}
