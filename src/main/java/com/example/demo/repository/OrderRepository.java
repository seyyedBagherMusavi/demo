package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = """            
            SELECT SUM(o.count * i.price) FROM Order o JOIN o.instrument i WHERE o.userId =:userId AND o.timestamp>= 
            :startTime       
            """)
            Double calculateTotalAmountForUserWithinLast10Minutes(@Param("userId") String userId,@Param("startTime") LocalDateTime startTime);
}
