package com.example.services;

import java.util.List;

import com.example.entities.Personne;
import com.example.repositories.PersonneRepository;
import com.example.views.personne.Formulaire;
import com.example.views.personne.RenderPersonne;

public class PersonneService {
    private final PersonneRepository personneRepository;


    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public void index() {
        try {
            List<Personne> personnes = personneRepository.findAll();
            if (personnes.isEmpty()) {
                System.out.println("\n🔹 Aucune personne trouvée dans la base de données. 🔹\n");
                return;
            }
            RenderPersonne.liste(personnes);
        } catch (Exception e) {
            System.err.println("\n❌ Erreur lors de la récupération des personnes ❌");
            e.printStackTrace();
        }
    }

    public void create() {
        Formulaire formData = new Formulaire();
        Personne nouvellePersonne = formData.register();

        try {
            personneRepository.save(nouvellePersonne);
            System.out.println("\n✅ Personne créée avec succès !");
        } catch (Exception e) {
            System.err.println("\n❌ Erreur lors de la création de la personne.");
            e.printStackTrace();
        }
    }

    public void findById(int id) {
        try {

            Personne personne = personneRepository.findById(id);
            if (personne != null) {
               RenderPersonne.rechercheUnePersonne(personne);
            } else {
                System.out.println("\n🔍 Personne non trouvée avec l'id : " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ Veiller donne une bonne id !");
        }
    }
}
