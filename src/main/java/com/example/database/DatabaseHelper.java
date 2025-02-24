package com.example.database;

import com.example.config.DatabaseConnection;
import java.sql.*;

public class DatabaseHelper {
    
    private static DatabaseHelper instance;
    private final DatabaseConnection databaseConnection;

    private DatabaseHelper() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }

    /**
     * Exécute une requête SELECT et retourne un ResultSet.
     */
    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        Connection connection = databaseConnection.connect();
        PreparedStatement statement = connection.prepareStatement(query);
        setParameters(statement, params);
        return statement.executeQuery();
    }

    /**
     * Exécute une requête INSERT, UPDATE ou DELETE et retourne le nombre de lignes affectées.
     */
    public int executeUpdate(String query, Object... params) throws SQLException {
        Connection connection = databaseConnection.connect();
        PreparedStatement statement = connection.prepareStatement(query);
        setParameters(statement, params);
        int rowsAffected = statement.executeUpdate();
        statement.close();
        databaseConnection.close();
        return rowsAffected;
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
