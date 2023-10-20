package com.example.demo.service.mapper;


import com.example.demo.model.Instrument;
import com.example.demo.model.Order;
import com.example.demo.service.dto.InstrumentDTO;
import com.example.demo.service.dto.OrderDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Order} and its DTO {@link OrderDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
}
