package com.bank.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "retrait")
public class Retrait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_retrait")
    private Integer nRetrait;

    @Column(name = "n_cheque")
    private String nCheque;

    @Column(name = "n_compte")
    private String nCompte;

    @Column(name = "Montant")
    private BigDecimal montant;

    // Constructors
    public Retrait() {
    }

    public Retrait(String nCheque, String nCompte, BigDecimal montant) {
        this.nCheque = nCheque;
        this.nCompte = nCompte;
        this.montant = montant;
    }

    // Getters and setters
    public Integer getnRetrait() {
        return nRetrait;
    }

    public void setnRetrait(Integer nRetrait) {
        this.nRetrait = nRetrait;
    }

    public String getnCheque() {
        return nCheque;
    }

    public void setnCheque(String nCheque) {
        this.nCheque = nCheque;
    }

    public String getnCompte() {
        return nCompte;
    }

    public void setnCompte(String nCompte) {
        this.nCompte = nCompte;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "nRetrait=" + nRetrait +
                ", nCheque='" + nCheque + '\'' +
                ", nCompte='" + nCompte + '\'' +
                ", montant=" + montant +
                '}';
    }
}
