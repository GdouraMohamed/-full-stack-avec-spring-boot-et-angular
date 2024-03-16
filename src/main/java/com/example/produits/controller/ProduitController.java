package com.example.produits.controller;

import com.example.produits.entities.Produit;
import com.example.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Endpoint to retrieve all produits
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    // Endpoint to retrieve a produit by ID
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduit(id);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    // Endpoint to create a new produit
    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        Produit createdProduit = produitService.saveProduit(produit);
        return new ResponseEntity<>(createdProduit, HttpStatus.CREATED);
    }

    // Endpoint to update an existing produit
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setIdProduit(id);
        Produit updatedProduit = produitService.updateProduit(produit);
        return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
    }

    // Endpoint to delete a produit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduitById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
