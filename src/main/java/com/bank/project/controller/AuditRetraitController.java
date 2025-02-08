package com.bank.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.project.service.AuditRetraitService;
import com.bank.project.entity.AuditRetrait;


@RestController
@RequestMapping("/api/audit-retraits")
public class AuditRetraitController {

    @Autowired
    private AuditRetraitService auditRetraitService;

    @GetMapping
    public List<AuditRetrait> getAllAuditRetraits() {
        return auditRetraitService.getAllAuditRetraits();
    }

    @GetMapping("/client/{nCompte}")
    public List<AuditRetrait> getAuditRetraitsByNCompte(@PathVariable("nCompte") String nCompte) {
        return auditRetraitService.getAuditRetraitsByNCompte(nCompte);
    }
}
