package com.bank.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.project.entity.AuditRetrait;
import com.bank.project.repository.AuditRetraitRepository;


@Service
public class AuditRetraitService {

    @Autowired
    private AuditRetraitRepository auditRetraitRepository;

    public List<AuditRetrait> getAllAuditRetraits() {
        return auditRetraitRepository.findAll();
    }

    public List<AuditRetrait> getAuditRetraitsByNCompte(String nCompte) {
        return auditRetraitRepository.findByNCompte(nCompte);
    }
}
