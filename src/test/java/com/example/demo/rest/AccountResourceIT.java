package com.example.demo.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.IntegrationTest;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.mapper.AccountMapper;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationTest
@AutoConfigureMockMvc
public class AccountResourceIT {

    private final static String userId = "aaa";
    private final static BigDecimal amount = new BigDecimal("100.0");

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EntityManager em;
    private static final String ENTITY_API_URL_ID = "/api/accounts/{userID}";
    @Autowired
    private MockMvc restAccountMockMvc;

    private Account account;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Account createEntity(EntityManager em) {
        Account account = new Account().setCredit(amount)
                .setUserId(userId);
        return account;
    }

    @BeforeEach
    public void initTest() {
        account = createEntity(em);
    }

    @Test
    @Transactional
    void getUserAccount() throws Exception {
        accountRepository.saveAndFlush(account);
        restAccountMockMvc
                .perform(get(ENTITY_API_URL_ID, account.getUserId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(account.getId().intValue()))
                .andExpect(jsonPath("$.userId").value(userId))
                .andExpect(jsonPath("$.credit").value(amount));
    }


}
