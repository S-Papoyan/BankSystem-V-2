package com.bankSystem.controller;

import com.bankSystem.exception.NotFoundException;
import com.bankSystem.model.Client;
import com.bankSystem.model.requestDTO.ClientDTO;
import com.bankSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(service.getAllClients());
    }

    @GetMapping("/getById")
    public Client getById(@RequestParam("id") int id) throws NotFoundException {
        return service.getById(id).orElseThrow(() -> new NotFoundException("Not found client with given ID"));
    }

    @GetMapping("/getBySocialCardOrPassport-number")
    public Client getBySocialCardOrPassportNumber(@RequestParam String socialCardOrPassportNumber) throws NotFoundException {
        return service.getBySocialCardOrPassportNumber(socialCardOrPassportNumber).orElseThrow(() -> new NotFoundException("Not found client with given social card or passport number"));
    }

    @GetMapping("/searchClient")
    public ResponseEntity<?> searchClient(@RequestParam String name) throws NotFoundException {
        List<Client> clients = service.searchClient(name);
        if (clients.isEmpty()) {
            throw new NotFoundException("Not found client with given name");
        }
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/createNewClient")
    public ResponseEntity<?> createNewClient(@RequestBody ClientDTO clientDTO) {
        service.createNewClient(clientDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestParam String socialCardOrPassportNumber, @RequestBody ClientDTO clientDTO) throws NotFoundException {
        service.update(socialCardOrPassportNumber, clientDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteClient(@RequestParam String socialCardOrPassportNumber) throws NotFoundException {
        service.delete(socialCardOrPassportNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}