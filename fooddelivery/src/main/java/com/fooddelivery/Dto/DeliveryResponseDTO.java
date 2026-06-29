package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Delivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDTO {
    private Integer id;
    private String trackingCode;
    private String status;
    private String assignedAt;
    private String pickedUpAt;
    private String deliveredAt;
    private OrderSummaryDTO order;

    public static DeliveryResponseDTO fromEntity(Delivery delivery) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();
        dto.setId(delivery.getId());
        dto.setTrackingCode(delivery.getTrackingCode());
        dto.setStatus(delivery.getStatus());
        dto.setAssignedAt(delivery.getAssignedAt());
        dto.setPickedUpAt(delivery.getPickedUpAt());
        dto.setDeliveredAt(delivery.getDeliveredAt());
        dto.setOrder(OrderSummaryDTO.fromEntity(delivery.getOrder()));

        return dto;
    }

    public static List<DeliveryResponseDTO> fromEntity(List<Delivery> deliveries) {

        List<DeliveryResponseDTO> dtos = new ArrayList<>();

        for (Delivery delivery : deliveries) {
            dtos.add(fromEntity(delivery));
        }

        return dtos;
    }
}
