package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.DeliveryDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeliveryDriverRepository extends JpaRepository<DeliveryDriver, Integer> {
    @Query("""

            SELECT d
        FROM DeliveryDriver d
        WHERE d.isOnline = true
        AND d.isActive = true
        """)
    List<DeliveryDriver> findOnlineDrivers();
}
