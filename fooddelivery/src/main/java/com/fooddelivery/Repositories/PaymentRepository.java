package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment,Integer> {
    @Query("""
        SELECT p
        FROM Payment p
        WHERE p.order.id = :orderId
        AND p.isActive = true
        """)
    Optional<Payment> findByOrderId(@Param("orderId") Integer orderId);
}
