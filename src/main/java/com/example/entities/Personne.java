package com.example.entities;

import com.example.interfaces.Identifiable;


public class Personne implements Identifiable {
    private int id;
    private String code;
    private String nom;
    private String prenom;
    private String dateNaissance;


    public Personne() {
    }

    public Personne(int id, String code, String nom, String prenom, String dateNaissance) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
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

    public String getDateNaissance() { 
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) { 
        this.dateNaissance = dateNaissance;
    }
}
