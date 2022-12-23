package com.example.croftingprj.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock extends Users implements Serializable {

    private String adresse;


    @OneToMany(mappedBy = "stock" ,fetch = FetchType.LAZY)
    private List<Produit> produits = new ArrayList<>();

    @OneToMany(mappedBy = "stock",fetch = FetchType.LAZY)
    private List<AppelOffre> appeleOffres = new ArrayList<>();

    public Stock() {
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @JsonIgnore
   public List<Produit> getProduits() {
        return produits;
  }
    @JsonSetter
   public void setProduits(List<Produit> produits) {
       this.produits = produits;
   }


    @JsonIgnore
    public List<AppelOffre> getAppeleOffres() {
        return appeleOffres;
    }

    @JsonSetter
    public void setAppeleOffres(List<AppelOffre> appeleOffres) {
        this.appeleOffres = appeleOffres;
    }

}
