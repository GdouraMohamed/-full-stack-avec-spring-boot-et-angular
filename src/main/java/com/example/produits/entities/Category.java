package com.example.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

        @JsonIgnore /*Je demande à Spring de ne pas nous retourner la liste des
produits qui est incluse dans la catégorie.*/
        @OneToMany(mappedBy = "category") //, cascade = CascadeType.ALL
        private List<Produit> produits;
}
