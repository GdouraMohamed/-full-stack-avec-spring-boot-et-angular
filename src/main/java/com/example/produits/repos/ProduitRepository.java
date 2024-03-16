package com.example.produits.repos;

import com.example.produits.entities.Category;
import com.example.produits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit >:prix")
    List<Produit> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("SELECT p FROM Produit p WHERE p.category = ?1")
    List<Produit> findByCategorie(Category categorie);

}
