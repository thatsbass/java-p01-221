package com.example.repositories;


import com.example.entities.Personne;
import com.example.model.Model;

import java.sql.*;
import java.util.List;

public class PersonneRepository extends Model<Personne> {

    public PersonneRepository() {
        super("personne");
    }

    @Override
    public Personne findById(int id) throws SQLException {
        return super.findById(id);
    }

    @Override
    public List<Personne> findAll() throws SQLException {
        return super.findAll();
    }

    /**
     * Sauvegarder une personne
     */
    public int save(Personne personne) throws SQLException {
        String query = "INSERT INTO personne (code, nom, prenom, date_naissance) VALUES (?, ?, ?, ?)";

        return super.executeUpdate(query, 
            personne.getCode(),
            personne.getNom(),
            personne.getPrenom(),
            new java.sql.Date(personne.getDateNaissance().getTime()) // ✅ Conversion en java.sql.Date
        );
    }

    /**
     * Mettre à jour une personne
     */
    public int update(Personne personne) throws SQLException {
        String query = "UPDATE personne SET code = ?, nom = ?, prenom = ?, date_naissance = ? WHERE id = ?";

        return super.executeUpdate(query,
            personne.getCode(),
            personne.getNom(),
            personne.getPrenom(),
            new java.sql.Date(personne.getDateNaissance().getTime()), // ✅ Conversion en java.sql.Date
            personne.getId()
        );
    }

    @Override
    public int delete(int id) throws SQLException {
        return super.delete(id);
    }

    /**
     * Mapper une ligne SQL (`ResultSet`) vers un objet `Personne`.
     */
    @Override
    protected Personne mapToEntity(ResultSet rs) throws SQLException {
        return new Personne(
            rs.getInt("id"),
            rs.getString("code"),
            rs.getString("nom"),
            rs.getString("prenom"),
            rs.getDate("date_naissance") // ✅ PostgreSQL retourne un Date
        );
    }
}
