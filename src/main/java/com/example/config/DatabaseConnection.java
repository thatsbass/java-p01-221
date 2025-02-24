package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private final DatabaseConfig config;

    private DatabaseConnection() {
        this.config = new DatabaseConfig();
        connectToDatabase();
    }


    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }


    private void connectToDatabase() {
        try {
            if (connection == null || connection.isClosed()) {
                String URL = config.getDatabaseUrl();
                String USER = config.getDatabaseUser();
                String PASSWORD = config.getDatabasePassword();
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connexion réussie !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Erreur de connexion à la base de données.");
        }
    }

    public Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connectToDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("✅ Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
