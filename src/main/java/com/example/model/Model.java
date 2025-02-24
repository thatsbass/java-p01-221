package com.example.model;

import com.example.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Model<T> {
    protected final String tableName;
    protected final DatabaseConnection databaseConnection;

    public Model(String tableName) {
        this.tableName = tableName;
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    /**
     * Trouver un élément par ID (retourne un objet `T`).
     */
    public T findById(int id) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        List<T> result = executeQuery(query, true, id);
        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Récupérer tous les éléments (retourne une `List<T>`).
     */
    public List<T> findAll() throws SQLException {
        String query = "SELECT * FROM " + tableName;
        return executeQuery(query,false);
    }

    /**
     * Exécuter une requête SELECT et mapper les résultats vers `T`.
     */
    private List<T> executeQuery(String query, boolean isSingle, Object... params) throws SQLException {
        List<T> resultList = new ArrayList<>();

        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            setParameters(statement, params);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    resultList.add(mapToEntity(rs));
                    if (isSingle) break;
                }
            }
        }
        return resultList;
    }

    /**
     * Exécuter une requête INSERT, UPDATE ou DELETE.
     */
    protected int executeUpdate(String query, Object... params) throws SQLException {
        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            setParameters(statement, params);
            return statement.executeUpdate();
        }
    }

    /**
     * Définit les paramètres d'une requête SQL.
     */
    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    /**
     * Supprimer un élément par ID.
     */
    public int delete(int id) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE id = ?";
        return executeUpdate(query, id);
    }

    /**
     * Mapper une ligne de `ResultSet` vers une entité `T`.
     * ⚠️ Cette méthode doit être implémentée par chaque Repository.
     */
    protected abstract T mapToEntity(ResultSet rs) throws SQLException;
}
