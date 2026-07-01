package com.fooddelivery.Services;

import com.fooddelivery.Dto.OrderItemRequestDTO;
import com.fooddelivery.Dto.OrderRequestDTO;
import com.fooddelivery.Dto.OrderResponseDTO;
import com.fooddelivery.Entities.Customer;
import com.fooddelivery.Entities.Order;
import com.fooddelivery.Entities.Restaurant;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.CustomerRepository;
import com.fooddelivery.Repositories.OrderItemRepository;
import com.fooddelivery.Repositories.OrderRepository;
import com.fooddelivery.Repositories.RestaurantRepository;
import com.fooddelivery.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public OrderResponseDTO createOrder(Integer customerId, Integer restaurantId, List<OrderItemRequestDTO> items) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setRestaurant(restaurant);
        order.setOrderCode(HelperUtils.generateCode("ORD"));
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setDeliveryFee(restaurant.getDeliveryFee());
        order.setDiscountAmount(0.0);

        orderRepository.save(order);

        return OrderResponseDTO.fromEntity(order);
    }
}
