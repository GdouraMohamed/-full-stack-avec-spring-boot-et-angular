package com.example.produits.entities;


import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produits")
public class Produit {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;

    @ManyToOne
//    @JoinColumn(name = "id_cat")
    private Category category;

    public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
