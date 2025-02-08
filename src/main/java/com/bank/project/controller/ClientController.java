package com.bank.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.bank.project.entity.Client;
import com.bank.project.service.ClientService;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{nCompte}")
    public ResponseEntity<Client> getClientByNCompte(@PathVariable("nCompte") String nCompte) {
        Optional<Client> client = clientService.getClientByNCompte(nCompte);
        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{nCompte}")
    public ResponseEntity<Client> updateClient(@PathVariable("nCompte") String nCompte, @RequestBody Client clientDetails) {
        try {
            Client updatedClient = clientService.updateClient(nCompte, clientDetails);
            return ResponseEntity.ok(updatedClient);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nCompte}")
    public ResponseEntity<Void> deleteClient(@PathVariable("nCompte") String nCompte) {
        try {
            clientService.deleteClient(nCompte);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

