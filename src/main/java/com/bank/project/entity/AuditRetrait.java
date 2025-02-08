package com.bank.project.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_retrait")
public class AuditRetrait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated ID for the audit record

    @Column(name = "type_action")
    private String typeAction;

    @Column(name = "date_mise_a_jour")
    private LocalDateTime dateMiseAJour;

    @Column(name = "n_retrait")
    private Integer nRetrait;

    @Column(name = "n_compte")
    private String nCompte;

    @Column(name = "nomclient")
    private String nomClient;

    @Column(name = "Montant_ancien")
    private BigDecimal montantAncien;

    @Column(name = "Montant_nouv")
    private BigDecimal montantNouv;

    @Column(name = "utilisateur")
    private String utilisateur;

    // Constructors
    public AuditRetrait() {
    }

    public AuditRetrait(String typeAction, LocalDateTime dateMiseAJour, Integer nRetrait, String nCompte, String nomClient, BigDecimal montantAncien, BigDecimal montantNouv, String utilisateur) {
        this.typeAction = typeAction;
        this.dateMiseAJour = dateMiseAJour;
        this.nRetrait = nRetrait;
        this.nCompte = nCompte;
        this.nomClient = nomClient;
        this.montantAncien = montantAncien;
        this.montantNouv = montantNouv;
        this.utilisateur = utilisateur;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
    }

    public LocalDateTime getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(LocalDateTime dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public Integer getnRetrait() {
        return nRetrait;
    }

    public void setnRetrait(Integer nRetrait) {
        this.nRetrait = nRetrait;
    }

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

    public BigDecimal getMontantAncien() {
        return montantAncien;
    }

    public void setMontantAncien(BigDecimal montantAncien) {
        this.montantAncien = montantAncien;
    }

    public BigDecimal getMontantNouv() {
        return montantNouv;
    }

    public void setMontantNouv(BigDecimal montantNouv) {
        this.montantNouv = montantNouv;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "AuditRetrait{" +
                "id=" + id +
                ", typeAction='" + typeAction + '\'' +
                ", dateMiseAJour=" + dateMiseAJour +
                ", nRetrait=" + nRetrait +
                ", nCompte='" + nCompte + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", montantAncien=" + montantAncien +
                ", montantNouv=" + montantNouv +
                ", utilisateur='" + utilisateur + '\'' +
                '}';
    }
}
