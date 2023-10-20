package com.example.demo.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import java.time.LocalDateTime;

@Entity
@Accessors(chain = true)
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Instrument instrument;

    private Integer count;

    private LocalDateTime timestamp;

    private String userId;

}
