package com.example.croftingprj.Repository;

import com.example.croftingprj.Entities.Category;
import com.example.croftingprj.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByCategory(String category);
    Produit findByReference(String reference);
}
