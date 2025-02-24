package com.example.entities;

import java.sql.Date;
import com.example.interfaces.Identifiable;


public class Personne implements Identifiable {
    private int id;
    private String code;
    private String nom;
    private String prenom;
    private Date date_naissance;

    public Personne() {
    }

    public Personne(int id, String code, String nom, String prenom, Date dateNaissance) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = dateNaissance;
    }

 
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() { 
        return date_naissance;
    }

    public void setDateNaissance(Date dateNaissance) { 
        this.date_naissance = dateNaissance;
    }
}
