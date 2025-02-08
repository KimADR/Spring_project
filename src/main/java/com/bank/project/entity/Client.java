package com.bank.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "n_compte")
    private String nCompte;

    @Column(name = "nomclient")
    private String nomClient;

    @Column(name = "solde")
    private BigDecimal solde;

    // Constructors
    public Client() {
    }

    public Client(String nCompte, String nomClient, BigDecimal solde) {
        this.nCompte = nCompte;
        this.nomClient = nomClient;
        this.solde = solde;
    }

    // Getters and setters
    public String getnCompte() {
        return nCompte;
    }

    public void setnCompte(String nCompte) {
        this.nCompte = nCompte;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nCompte='" + nCompte + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", solde=" + solde +
                '}';
    }
}

