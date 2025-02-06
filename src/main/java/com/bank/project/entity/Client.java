package com.bank.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compteId;

    private String nomClient;
    private Double solde;

    public Client() {}

    public Client(Long compteId, String nomClient, Double solde) {
        this.compteId = compteId;
        this.nomClient = nomClient;
        this.solde = solde;
    }

    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long compteId) {
        this.compteId = compteId;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Client [compteId=" + compteId + ", nomClient=" + nomClient + ", solde=" + solde + "]";
    }
}
