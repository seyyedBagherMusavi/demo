package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.dto.AccountDTO;
import com.example.demo.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    public AccountDTO findUserAccount(String userId){
        Account account = accountRepository.findAccountByUserId(userId).orElseThrow();
        return accountMapper.toDto(account);
    }
}
