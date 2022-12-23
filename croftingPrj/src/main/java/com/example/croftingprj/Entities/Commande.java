package com.example.croftingprj.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String reference;

    private LocalDate date;

    private Float prixTotal;


    private StatusCommande status ;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<CommandeItems> commandeItems = new ArrayList<>();

    @ManyToOne
    private Client client ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public StatusCommande getStatus() {
        return status;
    }

    public void setStatus(StatusCommande status) {
        this.status = status;
    }

    public List<CommandeItems> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(CommandeItems commandeItems) {
        this.commandeItems.add(commandeItems);
    }

    @JsonIgnore
    public Client getClient() {
        return client;
    }

    @JsonSetter
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", date=" + date +
                ", prixTotal=" + prixTotal +
                ", status=" + status +
                ", commadeItems=" + commandeItems +
                '}';
    }


}
