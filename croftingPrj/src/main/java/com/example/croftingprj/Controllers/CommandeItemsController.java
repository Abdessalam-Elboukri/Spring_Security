package com.example.croftingprj.Controllers;


import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.StatusCommande;
import com.example.croftingprj.Services.CommandeItemsService;
import com.example.croftingprj.Services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommandeItemsController {

    @Autowired
    CommandeItemsService commandeItemsService;

    @Autowired
    CommandeService commandeService;


    @GetMapping("/cart")
    public String getCurrentCommande(Model model,HttpSession session){
        Commande commandeEnCours = commandeService.findCommandeByClientIdAndStatus((Long) session.getAttribute("CLIENT_ID"), StatusCommande.EN_COURS);
        if(commandeEnCours!=null){
            List<CommandeItems> commandeItemsList =commandeEnCours.getCommandeItems();
            float prixTotal=0;
            for(CommandeItems commandeItem:commandeItemsList){
                prixTotal+=commandeItem.getPrix();
            }
            model.addAttribute("commadeItems",commandeItemsList);
            model.addAttribute("COMMANDE_ID",commandeEnCours.getId());
            model.addAttribute("COMMANDE_REF",commandeEnCours.getReference());
            model.addAttribute("prixTotal",prixTotal);
        }
        return "cart";
    }

}
