package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {
    @Test
    void equalsVerifier()  {

        Order order1 = new Order().setId(1L);
        Order order2 = new Order().setId(order1.getId());
        assertThat(order1).isEqualTo(order2);
        order2.setId(2L);
        assertThat(order1).isNotEqualTo(order2);
        order1.setId(null);
        assertThat(order1).isNotEqualTo(order2);
    }
}