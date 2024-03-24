package com.example.produits.service;

import com.example.produits.dto.ProduitDTO;
import com.example.produits.entities.Category;
import com.example.produits.entities.Produit;
import com.example.produits.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public ProduitDTO saveProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public ProduitDTO updateProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepository.save(convertDtoToEntity(p))); //retourne entité
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto(produitRepository.findById(id).get());
    }

    @Override
    public List<ProduitDTO> getAllProduits() {

        return produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        //OU BIEN
/*List<Produit> prods = produitRepository.findAll();
List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
for (Produit p : prods)
listprodDto.add(convertEntityToDto(p));
return listprodDto;*/
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }
    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }
    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }
    @Override
    public List<Produit> findByCategorie(Category categorie) {
        return produitRepository.findByCategorie(categorie);
    }



    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategoryIdCat(id);
    }
    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }
    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {
        //classic
       /* ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setIdProduit(produit.getIdProduit());
        produitDTO.setNomProduit(produit.getNomProduit());
        produitDTO.setPrixProduit(produit.getPrixProduit());
        produitDTO.setCategory(produit.getCategory());
        return produitDTO;*/

        return ProduitDTO.builder()
                .idProduit(produit.getIdProduit())
                .nomProduit(produit.getNomProduit())
               // .prixProduit(produit.getPrixProduit())
                .dateCreation(produit.getDateCreation())
                .nomCat(produit.getCategory().getNomCat())
               //.category(produit.getCategory())
                .build();
    }

    @Override
    public Produit convertEntityToDto(ProduitDTO produitDTO) {
        Produit produit = new Produit();
        produit.setIdProduit(produitDTO.getIdProduit());
        produit.setNomProduit(produitDTO.getNomProduit());
        produit.setPrixProduit(produitDTO.getPrixProduit());
        produit.setDateCreation(produitDTO.getDateCreation());
        produit.setCategory(produitDTO.getCategory());
        return produit;
    }

    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDto) {
        Produit produit = new Produit();
        produit.setIdProduit(produitDto.getIdProduit());
        produit.setNomProduit(produitDto.getNomProduit());
        produit.setPrixProduit(produitDto.getPrixProduit());
        produit.setDateCreation(produitDto.getDateCreation());
        produit.setCategory(produitDto.getCategory());
        return produit;
    }
}
