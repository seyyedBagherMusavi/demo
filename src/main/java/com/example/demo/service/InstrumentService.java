package com.example.demo.service;


import com.example.demo.model.Instrument;
import com.example.demo.repository.InstrumentRepository;
import com.example.demo.service.dto.InstrumentDTO;
import com.example.demo.service.mapper.InstrumentMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Instrument}.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class InstrumentService {

    private final Logger log = LoggerFactory.getLogger(InstrumentService.class);

    private final InstrumentRepository instrumentRepository;

    private final InstrumentMapper instrumentMapper;


    /**
     * Save a instrument.
     *
     * @param instrumentDTO the entity to save.
     * @return the persisted entity.
     */
    public InstrumentDTO save(InstrumentDTO instrumentDTO) {
        log.debug("Request to save Instrument : {}", instrumentDTO);
        Instrument instrument = instrumentMapper.toEntity(instrumentDTO);
        instrument = instrumentRepository.save(instrument);
        return instrumentMapper.toDto(instrument);
    }

    /**
     * Update a instrument.
     *
     * @param instrumentDTO the entity to save.
     * @return the persisted entity.
     */
    public InstrumentDTO update(InstrumentDTO instrumentDTO) {
        log.debug("Request to save Instrument : {}", instrumentDTO);
        Instrument instrument = instrumentMapper.toEntity(instrumentDTO);
        instrument = instrumentRepository.save(instrument);
        return instrumentMapper.toDto(instrument);
    }

    /**
     * Partially update a instrument.
     *
     * @param instrumentDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<InstrumentDTO> partialUpdate(InstrumentDTO instrumentDTO) {
        log.debug("Request to partially update Instrument : {}", instrumentDTO);

        return instrumentRepository
            .findById(instrumentDTO.getId())
            .map(existingInstrument -> {
                instrumentMapper.partialUpdate(existingInstrument, instrumentDTO);

                return existingInstrument;
            })
            .map(instrumentRepository::save)
            .map(instrumentMapper::toDto);
    }

    /**
     * Get all the instruments.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<InstrumentDTO> findAll() {
        log.debug("Request to get all Instruments");
        return instrumentRepository.findAll().stream().map(instrumentMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one instrument by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<InstrumentDTO> findOne(Long id) {
        log.debug("Request to get Instrument : {}", id);
        return instrumentRepository.findById(id).map(instrumentMapper::toDto);
    }

    /**
     * Delete the instrument by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Instrument : {}", id);
        instrumentRepository.deleteById(id);
    }
}
