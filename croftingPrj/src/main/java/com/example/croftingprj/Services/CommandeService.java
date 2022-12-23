package com.example.croftingprj.Services;

import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.StatusCommande;

import javax.servlet.http.HttpSession;

public interface CommandeService {
    void save(CommandeItems commandeItems, HttpSession session);
    Commande findCommandeByClientIdAndStatus(Long Id, StatusCommande statusCommande);
    void updateCommandePrix(Commande commande);
    void updateStatus(Commande commande);
    Commande findByRef(String reference);
}
