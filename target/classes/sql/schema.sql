-- Active: 1739820190295@@127.0.0.1@5432@java_db

CREATE TABLE Personne (
    id SERIAL PRIMARY KEY,
    code VARCHAR(100) UNIQUE NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    date_naissance DATE NOT NULL
);

CREATE TABLE Adresse (
    id SERIAL PRIMARY KEY,
    ville VARCHAR(100) NOT NULL,
    rue VARCHAR(100) NOT NULL,
    numero_villa VARCHAR(100) NOT NULL,
    personne_id INT,
    FOREIGN KEY (personne_id) REFERENCES Personne(id)
);

