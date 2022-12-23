package com.example.croftingprj.Services;

import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.Produit;

import java.util.List;

public interface ProduitService {
    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit, Long productId);
    Produit findByRef(String ref);
    Produit getProduitById(Long id);
    List<Produit> getAllProduits();
    List<Produit> findProuitsByCategory(String category);
    void updateProduitQuantity(Produit produit1, CommandeItems commandeItems);
}
