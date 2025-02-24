package com.example.entities;

import com.example.interfaces.Identifiable;

public class Adresse implements Identifiable {
    private int id;
    private String ville;
    private String rue;
    private String numero_villa;
    private int personne_id;


    public Adresse() {
    }

    public Adresse(int id, String ville, String rue, String numeroVilla, int personneId) {
        this.id = id;
        this.ville = ville;
        this.rue = rue;
        this.numero_villa = numeroVilla; 
        this.personne_id = personneId;   
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumeroVilla() { // correction du getter
        return numero_villa;
    }

    public void setNumeroVilla(String numeroVilla) { // correction du setter
        this.numero_villa = numeroVilla;
    }

    public int getPersonneId() { // correction du getter
        return personne_id;
    }

    public void setPersonneId(int personneId) { // correction du setter
        this.personne_id = personneId;
    }
}
