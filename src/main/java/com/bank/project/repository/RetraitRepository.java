package com.bank.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.project.entity.Retrait;


@Repository
public interface RetraitRepository extends JpaRepository<Retrait, Integer> {
    // You can add custom query methods here if needed, like:
    // List<Retrait> findByNCompte(String nCompte);
}
