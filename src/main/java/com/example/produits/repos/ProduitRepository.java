package com.example.produits.repos;

import com.example.produits.entities.Category;
import com.example.produits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit >:prix")
    List<Produit> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("SELECT p FROM Produit p WHERE p.category = ?1")
    List<Produit> findByCategorie(Category categorie);

    //esm mehod jpa + esm class + esm attribut marboutin m3 b3dhom
    List<Produit> findByCategoryIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit desc, p.prixProduit ASC")
    List<Produit> trierProduitsNomsPrix ();
}
