package com.example.demo.rest;

import com.example.demo.repository.InstrumentRepository;
import com.example.demo.service.InstrumentService;
import com.example.demo.service.dto.InstrumentDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.example.demo.model.Instrument}.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InstrumentResource {

    private final Logger log = LoggerFactory.getLogger(InstrumentResource.class);

    private static final String ENTITY_NAME = "instrument";

    private final InstrumentService instrumentService;


    /**
     * {@code POST  /instruments} : Create a new instrument.
     *
     * @param instrumentDTO the instrumentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new instrumentDTO, or with status {@code 400 (Bad Request)} if the instrument has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/instruments")
    public ResponseEntity<InstrumentDTO> createInstrument(@Valid @RequestBody InstrumentDTO instrumentDTO) throws URISyntaxException {
        log.debug("REST request to save Instrument : {}", instrumentDTO);

        InstrumentDTO result = instrumentService.save(instrumentDTO);
        return ResponseEntity
            .created(new URI("/api/instruments/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /instruments/:id} : Updates an existing instrument.
     *
     * @param id the id of the instrumentDTO to save.
     * @param instrumentDTO the instrumentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated instrumentDTO,
     * or with status {@code 400 (Bad Request)} if the instrumentDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the instrumentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/instruments/{id}")
    public ResponseEntity<InstrumentDTO> updateInstrument(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody InstrumentDTO instrumentDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Instrument : {}, {}", id, instrumentDTO);

        InstrumentDTO result = instrumentService.update(instrumentDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    /**
     * {@code PATCH  /instruments/:id} : Partial updates given fields of an existing instrument, field will ignore if it is null
     *
     * @param id the id of the instrumentDTO to save.
     * @param instrumentDTO the instrumentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated instrumentDTO,
     * or with status {@code 400 (Bad Request)} if the instrumentDTO is not valid,
     * or with status {@code 404 (Not Found)} if the instrumentDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the instrumentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/instruments/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<InstrumentDTO> partialUpdateInstrument(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody InstrumentDTO instrumentDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Instrument partially : {}, {}", id, instrumentDTO);


        Optional<InstrumentDTO> result = instrumentService.partialUpdate(instrumentDTO);

        return ResponseEntity.ok()
                .body(result.get());
    }

    /**
     * {@code GET  /instruments} : get all the instruments.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of instruments in body.
     */
    @GetMapping("/instruments")
    public List<InstrumentDTO> getAllInstruments() {
        log.debug("REST request to get all Instruments");
        return instrumentService.findAll();
    }

    /**
     * {@code GET  /instruments/:id} : get the "id" instrument.
     *
     * @param id the id of the instrumentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the instrumentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/instruments/{id}")
    public ResponseEntity<InstrumentDTO> getInstrument(@PathVariable Long id) {
        log.debug("REST request to get Instrument : {}", id);
        Optional<InstrumentDTO> instrumentDTO = instrumentService.findOne(id);
        return ResponseEntity.ok()
                .body(instrumentDTO.get());
    }

    /**
     * {@code DELETE  /instruments/:id} : delete the "id" instrument.
     *
     * @param id the id of the instrumentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/instruments/{id}")
    public ResponseEntity<Void> deleteInstrument(@PathVariable Long id) {
        log.debug("REST request to delete Instrument : {}", id);
        instrumentService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
