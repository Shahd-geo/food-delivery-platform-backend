package com.fooddelivery.Services;

import com.fooddelivery.Repositories.OrderRepository;
import com.fooddelivery.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
}
