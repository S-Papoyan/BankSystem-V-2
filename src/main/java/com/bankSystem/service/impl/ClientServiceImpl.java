package com.bankSystem.service.impl;


import com.bankSystem.exception.NotFoundException;
import com.bankSystem.model.Client;
import com.bankSystem.model.enums.Status;
import com.bankSystem.model.requestDTO.ClientDTO;
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

    @Override
    public Optional<Client> getBySocialCardOrPassportNumber(String socialCardOrPassportNumber) {
        return clientRepository.getBySocialCardOrPassportNumber(socialCardOrPassportNumber, socialCardOrPassportNumber);
    }

    @Override
    public List<Client> searchClient(String name) {
        return clientRepository.searchClient(name);
    }

    @Override
    public void createNewClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(0);
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setPatronymicName(clientDTO.getPatronymicName());
        client.setPassportNumber(clientDTO.getPassportNumber());
        client.setNationality(clientDTO.getNationality());
        client.setDateOfBirth(clientDTO.getDateOfBirth());
        client.setSex(clientDTO.getSex());
        client.setDateOfIssue(clientDTO.getDateOfIssue());
        client.setDateOfExpiry(clientDTO.getDateOfExpiry());
        client.setAuthority(clientDTO.getAuthority());
        client.setSocialCard(clientDTO.getSocialCard());
        client.setEmail(clientDTO.getEmail());
        client.setStatus(Status.INACTIVE);
        clientRepository.save(client);
    }

    @Override
    public void update(String socialCardOrPassportNumber, ClientDTO clientDTO) throws NotFoundException {
        Optional<Client> client = getBySocialCardOrPassportNumber(socialCardOrPassportNumber);
        if (client.isEmpty()) {
            throw new NotFoundException("Client not found with given social card or passport number");
        }
        Client updateClient = client.get();
        updateClient.setName(clientDTO.getName() == null ? updateClient.getName() : clientDTO.getName());
        updateClient.setSurname(clientDTO.getSurname() == null ? updateClient.getSurname() : clientDTO.getSurname());
        updateClient.setPatronymicName(clientDTO.getPatronymicName() == null ? updateClient.getPatronymicName() : clientDTO.getPatronymicName());
        updateClient.setPassportNumber(clientDTO.getPassportNumber() == null ? updateClient.getPassportNumber() : clientDTO.getPassportNumber());
        updateClient.setNationality(clientDTO.getNationality() == null ? updateClient.getNationality() : clientDTO.getNationality());
        updateClient.setDateOfBirth(clientDTO.getDateOfBirth() == null ? updateClient.getDateOfBirth() : clientDTO.getDateOfBirth());
        updateClient.setSex(clientDTO.getSex() == null ? updateClient.getSex() : clientDTO.getSex());
        updateClient.setDateOfIssue(clientDTO.getDateOfIssue() == null ? updateClient.getDateOfIssue() : clientDTO.getDateOfIssue());
        updateClient.setDateOfExpiry(clientDTO.getDateOfExpiry() == null ? updateClient.getDateOfExpiry() : clientDTO.getDateOfExpiry());
        updateClient.setAuthority(clientDTO.getAuthority() == null ? updateClient.getAuthority() : clientDTO.getAuthority());
        updateClient.setSocialCard(clientDTO.getSocialCard() == null ? updateClient.getSocialCard() : clientDTO.getSocialCard());
        updateClient.setEmail(clientDTO.getEmail() == null ? updateClient.getEmail() : clientDTO.getEmail());
        updateClient.setStatus(updateClient.getStatus());
        clientRepository.save(updateClient);
    }

    @Override
    public void delete(String socialCardOrPassportNumber) throws NotFoundException {
        Optional<Client> client = getBySocialCardOrPassportNumber(socialCardOrPassportNumber);
        if (client.isEmpty()) {
            throw new NotFoundException("Client not found with given social card or passport number");
        }
        clientRepository.delete(client.get());
    }
}