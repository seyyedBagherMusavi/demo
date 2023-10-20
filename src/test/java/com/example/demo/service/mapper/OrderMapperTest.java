package com.example.demo.service.mapper;

import org.junit.jupiter.api.BeforeEach;

class OrderMapperTest {

    private OrderMapper orderMapper;

    @BeforeEach
    public void setUp() {
        orderMapper = new OrderMapperImpl();
    }
}
