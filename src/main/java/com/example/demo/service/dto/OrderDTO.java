package com.example.demo.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.demo.model.Order} entity.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private Long id;

    private LocalDateTime timestamp;

    @NotNull
    private Integer count;

    private String userId;

    private InstrumentDTO instrument;

}
