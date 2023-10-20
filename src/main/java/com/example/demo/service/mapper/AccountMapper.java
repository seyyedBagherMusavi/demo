package com.example.demo.service.mapper;

import com.example.demo.model.Account;
import com.example.demo.service.dto.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {}
