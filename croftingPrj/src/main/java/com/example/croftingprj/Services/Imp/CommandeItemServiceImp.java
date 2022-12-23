package com.example.croftingprj.Services.Imp;

import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.Produit;
import com.example.croftingprj.Repository.CommandeItemRepository;
import com.example.croftingprj.Repository.CommandeRepository;
import com.example.croftingprj.Services.CommandeItemsService;
import com.example.croftingprj.Services.ProduitService;
import com.example.croftingprj.Utils.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@Service
public class CommandeItemServiceImp implements CommandeItemsService {


    @Autowired
    ProduitService produitService;

    @Autowired
    CommandeItemRepository commandItemepository;

    @Override
    public CommandeItems save(CommandeItems commandeItems, Commande commande) {
        commandeItems.setReference(GenerateReference.applyGenerateReference());
        commandeItems.setPrix(commandeItems.getQuantity()*commandeItems.getProduit().getPrix_initial());
        commandeItems.setCommande(commande);
        commandItemepository.save(commandeItems);
        return commandeItems;
    }

    @Override
    public Boolean validateCommandeItem(CommandeItems commandeItems1) {
            if (commandeItems1 != null) {
                Produit produit = produitService.findByRef(commandeItems1.getProduit().getReference());
                if (produit == null && produit.equals(new Produit())) {
                    return false;
                } else if (commandeItems1.getQuantity() <= 0
                        || commandeItems1.getQuantity() > produit.getQuantity()) {
                    return false;
                }
            }
        return true;
    }

    @Override
    public CommandeItems getByReference(String ref) {
        return null;
    }

}
