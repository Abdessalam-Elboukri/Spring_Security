package com.example.croftingprj.Services;


import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface CommandeItemsService {

    CommandeItems save(CommandeItems commandeItems, Commande commande);

    Boolean validateCommandeItem(CommandeItems commandeItems);


    CommandeItems getByReference(String ref);
}
