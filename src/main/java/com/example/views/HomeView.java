package com.example.views;

import java.util.Scanner;
import com.example.config.AppProvider;

public class HomeView {
    private final Scanner scanner;
    AppProvider appProvider = AppProvider.getInstance();
    public HomeView(){
        this.scanner = new Scanner(System.in);
    }

    public  void showMenu() {
        int choix;
        do {
            System.out.println("\n================================================");
            System.out.println("    Bienvenue sur notre application SenGookh 🇸🇳   ");
            System.out.println("================================================");
            System.out.println("1️⃣  📂 Gestion des personnes");
            System.out.println("2️⃣  🏠 Gestion des adresses");
            System.out.println("3️⃣  🚪 Quitter");
            System.out.println("------------------------------------------------");
            System.out.print("➡️  Faites votre choix : ");
    
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Veuillez entrer un nombre valide !");
                scanner.next();
            }
    
            choix = scanner.nextInt();
            scanner.nextLine();
    
            switch (choix) {
                case 1:
                    appProvider.getPersonneController().showMenuPersonne();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("\n👋 Merci d'avoir utilisé notre application. À bientôt !");
                    break;
                default:
                    System.out.println("\n⚠️ Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 3);
    }
    

}
