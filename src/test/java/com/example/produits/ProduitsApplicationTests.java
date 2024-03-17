package com.example.produits;

import com.example.produits.entities.Category;
import com.example.produits.entities.Produit;
import com.example.produits.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit() {
		List<Produit> produits = new ArrayList<>();
		produits.add(new Produit("PC Dell", 2200.500, new Date()));
		produits.add(new Produit("Laptop HP", 1800.750, new Date()));
		produits.add(new Produit("Smartphone Samsung", 1000.0, new Date()));
		for (Produit p : produits) {
			produitRepository.save(p);
		}
	}

	@Test
	public void testFindProduitById() {
		Produit p = produitRepository.findById(1L).orElse(null);
		assertNotNull(p, "Produit not found");
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		// Retrieve a Produit object by its ID
		Produit p = produitRepository.findById(1L).orElse(null);

		// Assert that the Produit object is not null
		assertNotNull(p, "Produit not found");

		// Update the price of the Produit object
		p.setPrixProduit(2000.0);

		// Save the updated Produit object
		produitRepository.save(p);

		// Retrieve the same Produit object again to confirm the update
		Produit updatedProduit = produitRepository.findById(1L).orElse(null);

		// Assert that the updated Produit object is not null
		assertNotNull(updatedProduit, "Updated Produit not found");

		// Assert that the price of the updated Produit object matches the updated value
		assertEquals(2000.0, updatedProduit.getPrixProduit(), 0.001);

		// Print the updated Produit object
		System.out.println(updatedProduit);
	}

	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById(1L);
	}

	@Test
	public void testFindAllProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods)
			System.out.println(p.getNomProduit());
	}

	@Test
	public void testFindProduitByNom() {
		// Call the repository method to find products by name
		List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
		// Print out the details of each product
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindProduitByNomContains() {
		// Call the repository method to find products by name
		List<Produit> prods = produitRepository.findByNomProduitContains("HP");
		// Print out the details of each product
		for (Produit p : prods) {
			System.out.println(p.getNomProduit());
		}
	}

	@Test
	public void testFindByNomPrix() {
		// Call the repository method to find products by name and price
		List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 2200.5);

		// Print out the details of each product
		for (Produit p : prods) {
			System.out.println(p.getNomProduit());
		}
	}

	@Test
	public void testFindByCategorie() {
		// Create a mock category
		Category cat = new Category();
		cat.setIdCat(2L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		// Print out the details of each product
		for (Produit p : prods) {
			System.out.println(p.getCategory().toString());
		}
	}

	@Test
	public void testFindByCategory() {

		List<Produit> produits = produitRepository.findByCategoryIdCat(2L);
		for (Produit p : produits) {
			System.out.println(p.getCategory().toString());
		}
	}

	@Test
	public void testfindByOrderByNomProduitAsc()
	{
		List<Produit> prods =
				produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
		{
			System.out.println(p.getNomProduit());
		}
	}

	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods)
		{
			System.out.println(p.getNomProduit()+" - "+p.getPrixProduit());
		}
	}


}



