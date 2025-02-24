package com.example;

import java.sql.Connection;
import com.example.config.DatabaseConnection;
import com.example.database.DatabaseSeeder;


public class Main {
    public static void main(String[] args) {
     
        Connection conn = DatabaseConnection.getInstance().connect();
        
        if (conn != null) {
            System.out.println("✅ Connexion établie avec succès !");

            DatabaseSeeder seeder = new DatabaseSeeder();
            seeder.seedDatabase();
            DatabaseConnection.getInstance().close();
        } else {
            System.out.println("❌ Échec de la connexion à la base de données.");
        }
    }
}
