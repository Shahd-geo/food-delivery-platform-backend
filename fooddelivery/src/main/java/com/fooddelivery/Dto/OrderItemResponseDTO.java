package com.fooddelivery.Dto;

import com.fooddelivery.Entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {
    private Integer id;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private String specialInstructions;

    public static OrderItemResponseDTO fromEntity(OrderItem orderItem) {
        OrderItemResponseDTO dto = new OrderItemResponseDTO();
        dto.setId(orderItem.getId());
        dto.setQuantity(orderItem.getQuantity());
        dto.setUnitPrice(orderItem.getUnitPrice());
        dto.setTotalPrice(orderItem.getTotalPrice());
        dto.setSpecialInstructions(orderItem.getSpecialInstructions());

        return dto;
    }

    public static List<OrderItemResponseDTO> fromEntity(List<OrderItem> orderItems) {
        List<OrderItemResponseDTO> dtos = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            dtos.add(fromEntity(orderItem));
        }

        return dtos;
    }
}
