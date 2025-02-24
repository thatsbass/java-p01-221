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

            // ✅ Conversion d'une String en java.sql.Date
            Date dateNaissance = Date.valueOf("1990-05-15"); // Format YYYY-MM-DD

            // ✅ Création d'une personne avec la date correcte
            Personne p = new Personne(0, "P001", "Diaw", "Bassirou", dateNaissance);
            personneRepo.save(p);

            // ✅ Récupérer une personne par ID
            Personne found = personneRepo.findById(1);
            if (found != null) {
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


// import java.sql.Connection;
// import com.example.config.DatabaseConnection;
// import com.example.database.DatabaseSeeder;


// public class Main {
//     public static void main(String[] args) {
     
//         Connection conn = DatabaseConnection.getInstance().connect();
        
//         if (conn != null) {
//             System.out.println("✅ Connexion établie avec succès !");

//             DatabaseSeeder seeder = new DatabaseSeeder();
//             seeder.seedDatabase();
//             DatabaseConnection.getInstance().close();
//         } else {
//             System.out.println("❌ Échec de la connexion à la base de données.");
//         }
//     }
// }
