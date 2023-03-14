package com.bankSystem.service;

import com.bankSystem.exception.NotFoundException;
import com.bankSystem.model.Client;
import com.bankSystem.model.requestDTO.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<?> getAllClients();

    Optional<Client> getById(int id) throws NotFoundException;

    Optional<Client> getBySocialCardOrPassportNumber(String socialCardOrPassportNumber);

    List<Client> searchClient(String name);

    void createNewClient(ClientDTO clientDTO);

    void update(String socialCardOrPassportNumber, ClientDTO clientDTO) throws NotFoundException;

    void delete(String socialCardOrPassportNumber) throws NotFoundException;

}
