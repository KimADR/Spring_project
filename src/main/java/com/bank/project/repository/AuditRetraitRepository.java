package com.bank.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.project.entity.AuditRetrait;


@Repository
public interface AuditRetraitRepository extends JpaRepository<AuditRetrait, Long> {

    //Custom queries if you need
    List<AuditRetrait> findByNCompte(String nCompte);
}
