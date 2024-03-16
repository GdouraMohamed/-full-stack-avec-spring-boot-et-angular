package com.example.produits.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idCat;
        private String nomCat;
        private String descriptionCat;

        @OneToMany(mappedBy = "category") //, cascade = CascadeType.ALL
        private List<Produit> produits;
}
