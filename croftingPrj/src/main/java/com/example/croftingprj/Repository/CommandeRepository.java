package com.example.croftingprj.Repository;

import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.StatusCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findCommandeByClientIdAndStatus(Long id, StatusCommande statusCommande);

    Commande findByReference(String ref);
}
