package com.example.database;

import com.example.config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CrudRepository<T> {

    private final DatabaseConnection databaseConnection;
    private final String tableName;
    private final Function<ResultSet, T> mapper;

    public CrudRepository(String tableName, Function<ResultSet, T> mapper) {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.tableName = tableName;
        this.mapper = mapper;
    }

    /**
     * Exécute une requête SELECT et retourne une liste d'objets T.
     */
    public List<T> findAll() throws SQLException {
        List<T> results = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                results.add(mapper.apply(resultSet));
            }
        }
        return results;
    }

    /**
     * Recherche un élément par son ID.
     */
    public T findById(int id) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        
        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapper.apply(resultSet);
                }
            }
        }
        return null;
    }

    /**
     * Insère une nouvelle ligne dans la base de données.
     */
    
    public int create(String query, Object... params) throws SQLException {
        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            setParameters(statement, params);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Retourne l'ID généré
                    }
                }
            }
            return -1;
        }
    }

    /**
     * Met à jour une ligne existante.
     */
    public int update(String query, Object... params) throws SQLException {
        return executeUpdate(query, params);
    }

    /**
     * Supprime une ligne par son ID.
     */
    public int deleteById(int id) throws SQLException {
        return executeUpdate("DELETE FROM " + tableName + " WHERE id = ?", id);
    }

    /**
     * Exécute une requête UPDATE ou DELETE.
     */
    private int executeUpdate(String query, Object... params) throws SQLException {
        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            setParameters(statement, params);
            return statement.executeUpdate();
        }
    }

    /**
     * Configure les paramètres pour un PreparedStatement.
     */
    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
