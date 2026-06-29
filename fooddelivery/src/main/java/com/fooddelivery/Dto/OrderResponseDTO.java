package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Integer id;
    private String orderCode;
    private LocalDateTime orderDate;
    private String status;
    private Double subtotal;
    private Double deliveryFee;
    private Double discountAmount;
    private Double totalAmount;
    private String deliveryNotes;
    private CustomerSummaryDTO customer;
    private RestaurantSummaryDTO restaurant;
    private List<OrderItemResponseDTO> orderItems;
    public static OrderResponseDTO fromEntity(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setOrderCode(order.getOrderCode());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setSubtotal(order.getSubtotal());
        dto.setDeliveryFee(order.getDeliveryFee());
        dto.setDiscountAmount(order.getDiscountAmount());
        dto.setTotalAmount(order.getTotalAmount());

        dto.setDeliveryNotes(order.getDeliveryNotes());

        dto.setCustomer(CustomerSummaryDTO.fromEntity(order.getCustomer()));

        dto.setRestaurant(RestaurantSummaryDTO.fromEntity(order.getRestaurant()));

        dto.setOrderItems(OrderItemResponseDTO.fromEntity(order.getOrderItems()));

        return dto;
    }
    public static List<OrderResponseDTO> fromEntity(List<Order> orders) {

        List<OrderResponseDTO> dtos = new ArrayList<>();

        for (Order order : orders) {
            dtos.add(fromEntity(order));
        }

        return dtos;
    }
}
