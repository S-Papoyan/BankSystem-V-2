package com.bankSystem.service;

import com.bankSystem.exception.NotFoundException;
import com.bankSystem.model.Client;
import com.bankSystem.model.requestDTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<?> getAllClients();

    Optional<Client> getById(int id) throws NotFoundException;


}
