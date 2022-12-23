package com.example.croftingprj.Controllers;

import com.example.croftingprj.Entities.Produit;
import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Services.ProduitService;
import com.example.croftingprj.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProduitController {
    ProduitService produitService;
    public ProduitController(ProduitService produitService) { this.produitService = produitService; }

    @Autowired
    StockService stockService;


    @PostMapping("/new")
    public Produit addProduit(@RequestBody Produit produit) {
            return produitService.addProduit(produit);
    }

    @GetMapping("/all")
    public String getAllProduits(Model model){
        model.addAttribute("ALL_PRODUCTS" ,produitService.getAllProduits() );
        return "all_products";
    }

    @GetMapping("/ref/{ref}")
    public String getProduitByRef(@PathVariable String ref,Model model){
        model.addAttribute("PRODUCT_REF",produitService.findByRef(ref));
        return "product_detail";
    }

/*
    @PostMapping("/update/{produitId}")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable Long produitId){
        return produitService.updateProduit(produit, produitId);
    }




    @GetMapping("/{category}")
    public List<Produit> getAllProduitsByCategory(@PathVariable int category){

        return produitService.findProuitsByCategory(category);

    }
    */

}
