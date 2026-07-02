package com.fooddelivery.Services;

import com.fooddelivery.Dto.DeliveryDriverResponseDTO;
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

import java.time.LocalDateTime;
import java.util.List;

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
    //autoAssignDriver
    public DeliveryResponseDTO autoAssignDriver(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        List<DeliveryDriver> drivers = deliveryDriverRepository.findOnlineDrivers();
        if (drivers.isEmpty()) {
            throw new ResourceNotFoundException("No available drivers");
        }
        DeliveryDriver driver = drivers.get(0);
        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDeliveryDriver(driver);
        delivery.setTrackingCode(HelperUtils.generateCode("TRK"));
        delivery.setStatus("ASSIGNED");
        deliveryRepository.save(delivery);
        return DeliveryResponseDTO.fromEntity(delivery);
    }

    //updateDriverLocation
    public DeliveryDriverResponseDTO updateDriverLocation(Integer driverId, Double lat, Double lng) {
        DeliveryDriver driver = deliveryDriverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));
        driver.setCurrentLat(lat);
        driver.setCurrentLng(lng);
        deliveryDriverRepository.save(driver);
        return DeliveryDriverResponseDTO.fromEntity(driver);
    }
    //markDeliveryPickedUp
    public DeliveryResponseDTO markDeliveryPickedUp(Integer deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));
        delivery.setStatus("PICKED_UP");
        delivery.setPickedUpAt(LocalDateTime.now().toString());
        deliveryRepository.save(delivery);
        return DeliveryResponseDTO.fromEntity(delivery);
    }
    //markDeliveryDelivered
    public DeliveryResponseDTO markDeliveryDelivered(Integer deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));
        delivery.setStatus("DELIVERED");
        delivery.setDeliveredAt(LocalDateTime.now().toString());
        deliveryRepository.save(delivery);
        return DeliveryResponseDTO.fromEntity(delivery);
    }
    //getDeliveriesForDriver
    public List<DeliveryResponseDTO> getDeliveriesForDriver(Integer driverId, String status) {
        List<Delivery> deliveries = deliveryRepository.findByDeliveryDriverIdAndStatus(driverId, status);
        return DeliveryResponseDTO.fromEntity(deliveries);
    }

}
