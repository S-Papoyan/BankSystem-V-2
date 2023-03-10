package com.bankSystem.service.impl;

import com.bankSystem.model.Account;
import com.bankSystem.repository.AccountRepository;
import com.bankSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<?> getAllAccounts() {
        List<Account> all = accountRepository.findAll();

        return all;
    }
}
