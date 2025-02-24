package com.example;

import java.sql.SQLException;
import java.util.List;

import com.example.entities.Personne;
import com.example.repositories.PersonneRepository;
import java.sql.Date;

public class Main {
    
    public static void main(String[] args) {
        try {
            PersonneRepository personneRepo = new PersonneRepository();

            
            // Date dateNaissance = Date.valueOf("1990-05-15"); // Format YYYY-MM-DD

        
            // Personne p = new Personne(0, "P001", "Diaw", "Bassirou", dateNaissance);
            // personneRepo.save(p);

            Personne found = personneRepo.findById(6);
            if (found != null) {
                System.out.println("Prenom: " + found.getPrenom());
                System.out.println("Nom: " + found.getNom());
                System.out.println("Date de naissance: " + found.getDateNaissance());
            } else {
                System.out.println("Personne introuvable !");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
