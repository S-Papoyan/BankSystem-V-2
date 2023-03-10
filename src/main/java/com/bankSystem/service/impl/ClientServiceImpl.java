package com.bankSystem.service.impl;


import com.bankSystem.model.Client;
import com.bankSystem.repository.ClientRepository;
import com.bankSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<?> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(int id) {
        return clientRepository.findById(id);
    }
}