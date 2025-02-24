package com.example.database;

import com.example.config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private final DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

    /**
     * Exécute une requête SELECT et retourne une liste d'objets.
     */
    public List<Object[]> executeQuery(String query, boolean isSingle, Object... params) throws SQLException {
        List<Object[]> resultList = new ArrayList<>();

        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            setParameters(statement, params);

            try (ResultSet rs = statement.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    resultList.add(row);
                    if (isSingle) break;
                }
            }
        }
        return resultList;
    }

    /**
     * Exécute une requête INSERT, UPDATE ou DELETE.
     */
    public int executeUpdate(String query, Object... params) throws SQLException {
        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            setParameters(statement, params);
            return statement.executeUpdate();
        }
    }

    /**
     * Définit les paramètres pour un PreparedStatement.
     */
    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
