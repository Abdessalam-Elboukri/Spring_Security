package com.example.croftingprj.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Fornisseur extends Users implements Serializable {


    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.LAZY)
    private List<AppelOffre> appelOffres;

    public Fornisseur() {
    }

@JsonIgnore
    public List<AppelOffre> getAppelOffres() {
        return appelOffres;
    }

    public void setAppelOffres(List<AppelOffre> appelOffres) {
        this.appelOffres = appelOffres;
    }

}
