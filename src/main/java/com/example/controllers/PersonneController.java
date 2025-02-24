package com.example.controllers;

import java.util.Scanner;

import com.example.services.PersonneService;
import com.example.views.personne.MenuView;

public class PersonneController {

    private final Scanner scanner;
    PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.scanner = new Scanner(System.in);
        this.personneService = personneService;
    }

    public void showMenuPersonne() {
        int choix;
        do {
            MenuView.navigate();
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Veuillez entrer un nombre valide !");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine();
            if (choix == 6) {
                break;
            }
            switch (choix) {
                case 1:
                    personneService.create();
                    break;
                case 2:
                    personneService.index();
                    break;
                case 3:
                    break;
                case 4:
                System.out.print(" Veuiiler entrer son id : ");
                int idInput = scanner.nextInt();
                    personneService.findById(idInput);
                    break;
                default:
                    System.out.println("\n⚠️ Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);
    }
}
