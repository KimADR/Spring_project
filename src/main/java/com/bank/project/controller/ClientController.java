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

import com.bank.project.entity.Client;
import com.bank.project.repository.ClientRepository;

@RestController
@RequestMapping("/api/client")

public class ClientController {
	
	@Autowired
	private final ClientRepository clientRepository;
	
	
	public ClientController (ClientRepository clientRepository) {
		this.clientRepository=clientRepository;
	}
	
	@GetMapping("/list")
	public List<Client> getClient(){
	  return clientRepository.findAll();	
	}
	
	@PostMapping("/save")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		Client savedClient = clientRepository.save(client);
		return ResponseEntity.ok(savedClient);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
	    Optional<Client> clientOptional = clientRepository.findById(id);
	    
	    if (clientOptional.isPresent()) {
	        Client client1 = clientOptional.get();
	        client1.setNomClient(client.getNomClient()); // Update with provided values
	        client1.setSolde(client.getSolde());
	        Client updatedClient = clientRepository.save(client1);
	        return ResponseEntity.ok(updatedClient);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Long id) {
	    Optional<Client> clientOptional = clientRepository.findById(id);

	    if (clientOptional.isPresent()) {
	        return ResponseEntity.ok(clientOptional.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
	    if (clientRepository.existsById(id)) {
	        clientRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build(); 
	    }
	}
}

