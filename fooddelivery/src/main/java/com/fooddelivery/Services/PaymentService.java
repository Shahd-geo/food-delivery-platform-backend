package com.fooddelivery.Services;

import com.fooddelivery.Dto.PaymentRequestDTO;
import com.fooddelivery.Dto.PaymentResponseDTO;
import com.fooddelivery.Entities.Order;
import com.fooddelivery.Entities.Payment;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
import com.fooddelivery.Repositories.OrderRepository;
import com.fooddelivery.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {

        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        Payment payment = dto.toEntity();
        payment.setOrder(order);
        payment.setProcessedAt(LocalDateTime.now().toString());
        paymentRepository.save(payment);
        return PaymentResponseDTO.fromEntity(payment);
    }
    public PaymentResponseDTO refundPayment(Integer paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
        payment.setStatus("REFUNDED");
        paymentRepository.save(payment);
        return PaymentResponseDTO.fromEntity(payment);
    }
}
