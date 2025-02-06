package com.bank.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.project.entity.Client;
import com.bank.project.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
    private ClientRepository repo;

    public Client addClient(Client e) {
        return repo.save(e);
    }
}
