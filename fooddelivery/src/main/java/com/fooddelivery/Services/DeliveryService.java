package com.fooddelivery.Services;

import com.fooddelivery.Dto.DeliveryResponseDTO;
import com.fooddelivery.Entities.Delivery;
import com.fooddelivery.Entities.DeliveryDriver;
import com.fooddelivery.Entities.Order;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.DeliveryDriverRepository;
import com.fooddelivery.Repositories.DeliveryRepository;
import com.fooddelivery.Repositories.OrderRepository;
import com.fooddelivery.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DeliveryDriverRepository deliveryDriverRepository;

    //assignDriverToOrder
    public DeliveryResponseDTO assignDriverToOrder(Integer orderId, Integer driverId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                        .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));
        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDeliveryDriver(driver);
        delivery.setTrackingCode(HelperUtils.generateCode("TRK"));
        delivery.setStatus("ASSIGNED");
        deliveryRepository.save(delivery);
        return DeliveryResponseDTO.fromEntity(delivery);
    }
}
