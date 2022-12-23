package com.example.croftingprj.Services.Imp;

import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Entities.Commande;
import com.example.croftingprj.Entities.CommandeItems;
import com.example.croftingprj.Entities.StatusCommande;
import com.example.croftingprj.Repository.CommandeItemRepository;
import com.example.croftingprj.Repository.CommandeRepository;
import com.example.croftingprj.Services.ClientService;
import com.example.croftingprj.Services.CommandeItemsService;
import com.example.croftingprj.Services.CommandeService;
import com.example.croftingprj.Utils.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImp implements CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    CommandeItemsService commandeItemsService;




    @Override
    public void save(CommandeItems commandeItems, HttpSession session) {
        Optional<Client> clientOptional = clientService.findOne((Long) session.getAttribute("CLIENT_ID"));
        if(clientOptional.isPresent()) {
            Client client = (Client) clientOptional.get();
            if (commandeItemsService.validateCommandeItem(commandeItems)) {
                Commande commandeEncours = commandeRepository.findCommandeByClientIdAndStatus(client.getId(), StatusCommande.EN_COURS);
                if (commandeEncours == null) {
                    Commande commande = new Commande();
                    commande.setClient(client);
                    commande.setReference(GenerateReference.applyGenerateReference());
                    commande.setDate(LocalDate.now());
                    commande.setStatus(StatusCommande.EN_COURS);
                    commande.setPrixTotal(commandeItems.getQuantity()*commandeItems.getProduit().getPrix_initial());
                    commandeRepository.save(commande);
                    commandeItemsService.save(commandeItems, commande);
                } else {
                    commandeEncours.setCommandeItems(commandeItemsService.save(commandeItems, commandeEncours));
                    commandeRepository.save(commandeEncours);
                    updateCommandePrix(commandeEncours);
                }

            }
        }
    }


    @Override
    public void updateStatus(Commande commande) {
        commandeRepository.save(commande);
    }

    @Override
    public Commande findByRef(String reference) {
        return commandeRepository.findByReference(reference);
    }

    @Override
    public Commande findCommandeByClientIdAndStatus(Long Id, StatusCommande statusCommande) {
        return commandeRepository.findCommandeByClientIdAndStatus(Id,statusCommande);
    }

    @Override
    public void updateCommandePrix( Commande commande){
        List<CommandeItems> items= commande.getCommandeItems();
        Float prix= (float) 0;
        for(CommandeItems item : items){
            prix+=item.getPrix();
        }
        commande.setPrixTotal(prix);
        commandeRepository.save(commande);
    }




}
