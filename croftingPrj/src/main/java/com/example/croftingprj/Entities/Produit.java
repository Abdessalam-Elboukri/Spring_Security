package com.example.croftingprj.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String reference;
    private String nom;
    private Float prix_initial;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int quantity;

    @ManyToOne
    private Stock stock;

    @OneToMany (mappedBy = "produit")
    private List<CommandeItems> commandeItems = new ArrayList<>();

    public Produit() { }

    public Produit( String reference, String nom, Float prix_initial, String description, Category category, int quantity) {

        this.reference = reference;
        this.nom = nom;
        this.prix_initial = prix_initial;
        this.description = description;
        this.category = category;
        this.quantity = quantity;

    }

    public void setId(Long id) { this.id = id; }
    public void setReference(String reference) { this.reference = reference; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrix_initial(Float prix_initial) { this.prix_initial = prix_initial; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(Category category) { this.category = category; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    @JsonSetter
    public void setCommandeItems(List<CommandeItems> commandeItems) {
        this.commandeItems = commandeItems;
    }

    public Long getId() { return id; }
    public String getReference() { return reference; }
    public String getNom() { return nom; }
    public Float getPrix_initial() { return prix_initial; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public Stock getStock() {
        return stock;
    }
    @JsonIgnore
    public List<CommandeItems> getCommandeItems() {
        return commandeItems;
    }

}
