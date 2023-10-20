package com.example.demo.rest;

import com.example.demo.service.AccountService;
import com.example.demo.service.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountResource {


    private final Logger log = LoggerFactory.getLogger(InstrumentResource.class);

    private final AccountService accountService;
    /**
     * {@code GET  /instruments/:id} : get the "id" instrument.
     *
     * @param userId the id of the instrumentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the instrumentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/accounts/{userId}")
    public ResponseEntity<AccountDTO> getUserAccount(@PathVariable(name = "userId") String userId) {
        log.debug("REST request to get Account : {}", userId);
        AccountDTO accountDTO = accountService.findUserAccount(userId);
        return ResponseEntity.ok()
                .body(accountDTO);
    }
}
