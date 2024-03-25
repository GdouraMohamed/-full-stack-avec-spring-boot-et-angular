package com.example.produits.service;

import com.example.produits.dto.ProduitDTO;
import com.example.produits.entities.Category;
import com.example.produits.entities.Produit;

import java.util.List;

public interface ProduitService {
    ProduitDTO saveProduit(ProduitDTO p);
    ProduitDTO updateProduit(ProduitDTO p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    ProduitDTO getProduit(Long id);
    List<ProduitDTO> getAllProduits();
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom, Double prix);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();
    List<Produit> findByCategorie(Category categorie);


    ProduitDTO convertEntityToDto(Produit produit);
//    Produit convertEntityToDto(ProduitDTO produitDTO);
    Produit convertDtoToEntity(ProduitDTO produitDto);

    }
