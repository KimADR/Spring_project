package com.bank.project.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.project.entity.Retrait;
import com.bank.project.service.RetraitService;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/retraits")
public class RetraitController {

    @Autowired
    private RetraitService retraitService;

    @GetMapping
    public List<Retrait> getAllRetraits() {
        return retraitService.getAllRetraits();
    }

    @GetMapping("/{nRetrait}")
    public ResponseEntity<Retrait> getRetraitByNRetrait(@PathVariable("nRetrait") Integer nRetrait) {
        Optional<Retrait> retrait = retraitService.getRetraitByNRetrait(nRetrait);
        return retrait.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createRetrait(@RequestBody Retrait retrait) {
        try {
            Retrait createdRetrait = retraitService.createRetrait(retrait);
            return new ResponseEntity<>(createdRetrait, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Handle exceptions like InsufficientFunds
        }
    }

    @PutMapping("/{nRetrait}")
    public ResponseEntity<Retrait> updateRetrait(@PathVariable("nRetrait") Integer nRetrait, @RequestBody Retrait retraitDetails) {
        try {
            Retrait updatedRetrait = retraitService.updateRetrait(nRetrait, retraitDetails);
            return ResponseEntity.ok(updatedRetrait);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nRetrait}")
    public ResponseEntity<Void> deleteRetrait(@PathVariable("nRetrait") Integer nRetrait) {
        try {
            retraitService.deleteRetrait(nRetrait);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
