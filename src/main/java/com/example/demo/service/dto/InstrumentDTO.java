package com.example.demo.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.demo.model.Instrument} entity.
 */
@Data
@Accessors(chain = true)
public class InstrumentDTO implements Serializable {

    private Long id;

    private String name;

    @NotNull
    private Double price;
}
