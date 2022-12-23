package com.example.croftingprj.Services.Imp;

import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.Produit;
import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Repository.ProduitRepository;
import com.example.croftingprj.Services.ProduitService;
import com.example.croftingprj.Services.StockService;
import com.example.croftingprj.Utils.GenerateReference;
import com.example.croftingprj.Utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImp implements ProduitService {

    private final ProduitRepository produitRepository;
    public ProduitServiceImp(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Autowired
    StockService stockService;

    @Override
    public Produit addProduit(Produit produit) {
        if(produit==null) {
            throw new IllegalArgumentException("produit is null");
        }
        else if(produit.equals(new Produit())){
            throw new IllegalArgumentException("produit is Empty");
        }
        else if(produit.getNom()==null || produit.getPrix_initial()==null|| produit.getDescription()==null|| produit.getStock()==null){
            throw new IllegalArgumentException("Please fill all product information");
        }else{
            produit.setReference(GenerateReference.applyGenerateReference());
            return produitRepository.save(produit);
        }
    }



    @Override
    public Produit updateProduit(Produit produit,Long produitId) {

        Produit DBProduit = produitRepository.findById(produitId).orElse(null);
        assert DBProduit != null;
        DBProduit.setCategory(produit.getCategory());
        DBProduit.setNom(produit.getNom());
        DBProduit.setReference(produit.getReference());
        DBProduit.setPrix_initial(produit.getPrix_initial());
        DBProduit.setDescription(produit.getDescription());

        return produitRepository.save(DBProduit);

    }

    @Override
    public Produit findByRef(String ref) {
        return produitRepository.findByReference(ref);
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produit> getAllProduits() { return produitRepository.findAll(); }

    @Override
    public List<Produit> findProuitsByCategory(String category) {
        return  produitRepository.findByCategory(category);
    }

    @Override
    public void updateProduitQuantity(Produit produit1, CommandeItems commandeItems){
        produit1.setQuantity(produit1.getQuantity()-commandeItems.getQuantity());
        addProduit(produit1);
    }
}
