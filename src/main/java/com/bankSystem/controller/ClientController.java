package com.bankSystem.controller;

import com.bankSystem.exception.NotFoundException;
import com.bankSystem.model.Client;
import com.bankSystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
