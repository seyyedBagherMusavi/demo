package com.example.demo.service.controller;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
/**
 * this class check  complicate validation of orders
 *
 */
public class OrderServiceController {
    private final OrderRepository orderRepository;

    @Value("${demo.maxTrade}")
    private double maxTradePerTime;

    @Value("${demo.timePeriod}")
    private long timePeriod;


    /**
     * check validation of trade per min
     * @param order
     * @return
     */
    public boolean validation(Order order){
        LocalDateTime startTime = LocalDateTime.now().minusMinutes(timePeriod);
        double currentPrice = order.getCount()*order.getInstrument().getPrice();
        Double price = orderRepository.calculateTotalAmountForUserWithinLast10Minutes
                (order.getUserId(), startTime);
        if(price+currentPrice>maxTradePerTime){
           throw new RuntimeException(" you not allowed more trade");
        }
        return true;
    }
}
