package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Table(name = "account")
@Entity
@Data
@Accessors(chain = true)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private BigDecimal credit;
}
