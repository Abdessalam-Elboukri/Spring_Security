package com.example.croftingprj.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends Users implements Serializable{


    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<Commande> commandes ;

    public Client() {
    }

    //@JsonIgnore
    public List<Commande> getCommandes() {
        return commandes;
    }

    //@JsonSetter
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }


}
