package com.bank.project.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.project.entity.Client;
import com.bank.project.entity.Retrait;
import com.bank.project.repository.RetraitRepository;

import jakarta.transaction.Transactional;

@Service
public class RetraitService {

    @Autowired
    private RetraitRepository retraitRepository;

    @Autowired
    private ClientService clientService; // Inject ClientService

    public List<Retrait> getAllRetraits() {
        return retraitRepository.findAll();
    }

    public Optional<Retrait> getRetraitByNRetrait(Integer nRetrait) {
        return retraitRepository.findById(nRetrait);
    }

    @Transactional
    public Retrait createRetrait(Retrait retrait) {
        // 1. Validate retrait
        // 2. Check if client exists

        // 3. Update Client Balance (BE CAREFUL WITH CONCURRENCY - use appropriate transaction management)

        Client client = clientService.getClientByNCompte(retrait.getnCompte())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with nCompte: " + retrait.getnCompte()));

        BigDecimal currentBalance = client.getSolde();
        BigDecimal withdrawalAmount = retrait.getMontant();

        if (currentBalance.compareTo(withdrawalAmount) < 0) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        
        BigDecimal newBalance = currentBalance.subtract(withdrawalAmount);
        client.setSolde(newBalance);
        clientService.updateClient(client.getnCompte(), client);

        //SAVE THE RETRAIT (This will trigger the trigger)
        Retrait savedRetrait = retraitRepository.save(retrait);
        return savedRetrait;
    }

    @Transactional
    public Retrait updateRetrait(Integer nRetrait, Retrait retraitDetails) {
        Retrait retrait = retraitRepository.findById(nRetrait)
                .orElseThrow(() -> new ResourceNotFoundException("Retrait not found with nRetrait: " + nRetrait));

        //get Client from retrait
        Client client = clientService.getClientByNCompte(retrait.getnCompte())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with nCompte: " + retrait.getnCompte()));

        BigDecimal currentBalance = client.getSolde();
        BigDecimal oldAmount = retrait.getMontant();
        BigDecimal newAmount = retraitDetails.getMontant();

        BigDecimal newBalance = currentBalance.add(oldAmount).subtract(newAmount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }

        client.setSolde(newBalance);
        clientService.updateClient(client.getnCompte(), client);

        retrait.setnCheque(retraitDetails.getnCheque());
        retrait.setnCompte(retraitDetails.getnCompte());
        retrait.setMontant(retraitDetails.getMontant());

        return retraitRepository.save(retrait);
    }

//    @Transactional
//    public void deleteRetrait(Integer nRetrait) {
//        Retrait retrait = retraitRepository.findById(nRetrait)
//                .orElseThrow(() -> new ResourceNotFoundException("Retrait not found with nRetrait: " + nRetrait));
//
//        Client client = clientService.getClientByNCompte(retrait.getnCompte())
//                .orElseThrow(() -> new ResourceNotFoundException("Client not found with nCompte: " + retrait.getnCompte()));
//
//        BigDecimal currentBalance = client.getSolde();
//        BigDecimal withdrawalAmount = retrait.getMontant();
//
//        // Restore the balance by adding back the deleted withdrawal amount
//        BigDecimal newBalance = currentBalance.add(withdrawalAmount);
//        client.setSolde(newBalance);
//        clientService.updateClient(client.getnCompte(), client);
//
//        retraitRepository.delete(retrait);
//    }
    @Transactional
    public void deleteRetrait(Integer nRetrait) {
        Retrait retrait = retraitRepository.findById(nRetrait)
                .orElseThrow(() -> new ResourceNotFoundException("Retrait not found with nRetrait: " + nRetrait));

        retraitRepository.delete(retrait);
    }


    // Custom exception classes (you'll need to create these)
    @SuppressWarnings("serial")
	private static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @SuppressWarnings("serial")
	private static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}