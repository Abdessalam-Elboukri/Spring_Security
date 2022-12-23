package com.example.croftingprj.Controllers;

import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.StatusCommande;
import com.example.croftingprj.Repository.CommandeItemRepository;
import com.example.croftingprj.Services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CommandeController {

    @Autowired
    CommandeService commandeService;

    @Autowired
    CommandeItemRepository commandeItemRepository;



    @PostMapping("/add_to_cart")
    public String addCommande(@ModelAttribute("commande") CommandeItems commandeItems, HttpSession session) throws IOException {
        commandeService.save(commandeItems,session);
        return "redirect:/cart";
    }



    @PostMapping("/update")
    public String updateStatusCommande(@ModelAttribute Commande commande){
        Commande commande1 = commandeService.findByRef(commande.getReference());
        commande.setStatus(StatusCommande.EFFECTUER);
        commandeService.updateStatus(commande1);
        return "redirect:/cart";
    }



}
