package com.bank.project.repository;

import com.bank.project.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // You can add custom query methods here if needed, like:
    // Client findByNomClient(String nomClient);
}

