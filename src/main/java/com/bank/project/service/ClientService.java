package com.bank.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.project.entity.Client;
import com.bank.project.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientByNCompte(String nCompte) {
        return clientRepository.findById(nCompte);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(String nCompte, Client clientDetails) {
        Client client = clientRepository.findById(nCompte)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with nCompte: " + nCompte));

        client.setNomClient(clientDetails.getNomClient());
        client.setSolde(clientDetails.getSolde());

        return clientRepository.save(client);
    }

    public void deleteClient(String nCompte) {
        Client client = clientRepository.findById(nCompte)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with nCompte: " + nCompte));

        clientRepository.delete(client);
    }

    // Custom exception class (you'll need to create this)
    @SuppressWarnings("serial")
	private static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}