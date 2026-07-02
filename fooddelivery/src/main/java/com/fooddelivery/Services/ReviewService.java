package com.fooddelivery.Services;

import com.fooddelivery.Dto.ReviewResponseDTO;
import com.fooddelivery.Entities.Customer;
import com.fooddelivery.Entities.Restaurant;
import com.fooddelivery.Entities.Review;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.CustomerRepository;
import com.fooddelivery.Repositories.DeliveryDriverRepository;
import com.fooddelivery.Repositories.RestaurantRepository;
import com.fooddelivery.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    //leaveRestaurantReview
    public ReviewResponseDTO leaveRestaurantReview(Integer customerId, Integer restaurantId, int rating, String comment) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        Review review = new Review();
        review.setTargetType("RESTAURANT");
        review.setRating(rating);
        review.setComment(comment);
        review.setCreatedAt(LocalDateTime.now().toString());
        review.setCustomer(customer);
        review.setRestaurant(restaurant);
        reviewRepository.save(review);
        return ReviewResponseDTO.fromEntity(review);
    }
}
