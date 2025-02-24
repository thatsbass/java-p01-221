package com.example.database.seeders;

import com.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseSeeder {
    public static void main(String[] args) {
        DatabaseSeeder seeder = new DatabaseSeeder();
        seeder.seedDatabase();
    }

    public void seedDatabase() {
        Connection connection = DatabaseConnection.getInstance().connect();

        // Données de personnes sénégalaises
        String[] personnes = {
            "('PERS001', 'Ndiaye', 'Mamadou', '1990-05-10')",
            "('PERS002', 'Diop', 'Aissatou', '1985-07-15')",
            "('PERS003', 'Faye', 'Ibrahima', '1993-12-20')",
            "('PERS004', 'Sow', 'Fatou', '1998-03-25')",
            "('PERS005', 'Gueye', 'Cheikh', '2000-01-30')"
        };

        String[] adresses = {
            "('Dakar', 'Avenue Cheikh Anta Diop', '123', 1)",
            "('Thies', 'Rue du Marché', '45B', 2)",
            "('Saint-Louis', 'Boulevard Ndar Toute', '78', 3)",
            "('Kaolack', 'Quartier Medina Baye', '12A', 4)",
            "('Ziguinchor', 'Route de Kolda', '90C', 5)"
        };

        try {
            String insertPersonne = "INSERT INTO Personne (code, nom, prenom, date_naissance) VALUES ";
            for (String personne : personnes) {
                executeUpdate(connection, insertPersonne + personne);
            }

          
            String insertAdresse = "INSERT INTO Adresse (ville, rue, numero_villa, personne_id) VALUES ";
            for (String adresse : adresses) {
                executeUpdate(connection, insertAdresse + adresse);
            }

            System.out.println("✅ Données insérées avec succès !");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'insertion des données : " + e.getMessage());
        } finally {
            DatabaseConnection.getInstance().close();
        }
    }

    private void executeUpdate(Connection connection, String sql) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }
}
