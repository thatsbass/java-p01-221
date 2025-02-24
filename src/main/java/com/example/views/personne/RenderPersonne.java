package com.example.views.personne;

import java.util.List;

import com.example.entities.Personne;

public class RenderPersonne {

    public static void liste(List<Personne> personnes){
        System.out.println("\n===========================================");
        System.out.println("         📜 Liste des Personnes 📜         ");
        System.out.println("===========================================\n");

        for (Personne p : personnes) {
            System.out.println("🆔 ID              : " + p.getId());
            System.out.println("🔢 Code           : " + p.getCode());
            System.out.println("👤 Nom            : " + p.getNom());
            System.out.println("👤 Prénom         : " + p.getPrenom());
            System.out.println("🎂 Date de naissance : " + p.getDateNaissance());
            System.out.println("-------------------------------------------");
        }
    }

    public static void rechercheUnePersonne(Personne personne){
        System.out.println("\n🔍 Personne trouvée :");
        System.out.println("Nom : " + personne.getNom());
        System.out.println("Prénom : " + personne.getPrenom());
        System.out.println("Date de naissance : " + personne.getDateNaissance());
        System.out.println("Code : " + personne.getCode());
    }

}
