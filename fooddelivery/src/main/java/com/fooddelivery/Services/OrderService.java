package com.fooddelivery.Services;

import com.fooddelivery.Dto.OrderItemRequestDTO;
import com.fooddelivery.Dto.OrderRequestDTO;
import com.fooddelivery.Dto.OrderResponseDTO;
import com.fooddelivery.Entities.*;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.*;
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
    @Autowired
    private MenuItemRepository menuItemRepository;

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

    public OrderResponseDTO createOrder(
            Integer customerId,
            Integer restaurantId,
            List<OrderItemRequestDTO> items,
            String notes) {

        OrderResponseDTO response =
                createOrder(customerId, restaurantId, items);

        Order order = orderRepository.findById(response.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found"));

        order.setDeliveryNotes(notes);

        orderRepository.save(order);

        return OrderResponseDTO.fromEntity(order);
    }

    public OrderResponseDTO addMenuItemToOrder(Integer orderId, Integer menuItemId, int quantity) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not exist"));

        MenuItem item = menuItemRepository.findById(menuItemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Menu item not exist"));

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setMenuItem(item);
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(item.getPrice());
        orderItem.setTotalPrice(item.getPrice() * quantity);
        orderItemRepository.save(orderItem);

        order.getOrderItems().add(orderItem);
        order.setTotalAmount(order.getTotalAmount() + orderItem.getTotalPrice());

        orderRepository.save(order);

        return OrderResponseDTO.fromEntity(order);

    }
    public OrderResponseDTO removeMenuItemFromOrder(Integer orderId, Integer orderItemId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Order item not found"));
        orderItem.setIsActive(false);
        orderItemRepository.save(orderItem);
        return OrderResponseDTO.fromEntity(order);
    }
    public OrderResponseDTO applyDiscount(Integer orderId, Double discountAmount) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setDiscountAmount(discountAmount);
        orderRepository.save(order);
        return OrderResponseDTO.fromEntity(order);
    }
}