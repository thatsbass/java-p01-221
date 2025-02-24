package com.example.views.personne;

import java.sql.Date;
import java.util.Scanner;
import com.example.entities.Personne;

public class Formulaire {
    public Personne register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n📝 Création d'une nouvelle personne");
        System.out.println("===================================");

        System.out.print("🔤 Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("🔤 Entrez le prénom : ");
        String prenom = scanner.nextLine();

        Date dateNaissance = null;
        boolean validDate = false;

        while (!validDate) {
            System.out.print("📅 Entrez la date de naissance (YYYY-MM-DD) : ");
            String dateInput = scanner.nextLine();

            try {
                dateNaissance = Date.valueOf(dateInput);
                validDate = true;
            } catch (Exception e) {
                System.out.println("❌ Format de date invalide. Veuillez réessayer.");
            }
        }

        System.out.print("🆔 Entrez un code unique : ");
        String code = scanner.nextLine();

        Personne nouvellePersonne = new Personne();
        nouvellePersonne.setNom(nom);
        nouvellePersonne.setPrenom(prenom);
        nouvellePersonne.setDateNaissance(dateNaissance);
        nouvellePersonne.setCode(code);
        scanner.close();
        return nouvellePersonne;
        
    }
}
