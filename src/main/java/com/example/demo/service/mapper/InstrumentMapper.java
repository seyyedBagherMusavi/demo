package com.example.demo.service.mapper;


import com.example.demo.model.Instrument;
import com.example.demo.service.dto.InstrumentDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Instrument} and its DTO {@link InstrumentDTO}.
 */
@Mapper(componentModel = "spring")
public interface InstrumentMapper extends EntityMapper<InstrumentDTO, Instrument> {}
