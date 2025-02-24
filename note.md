
1 creer la table Personne, Adresse ( relation one to many ) :
```sql
CREATE TABLE Personne (
    id SERIAL PRIMARY KEY,
    code VARCHR(100) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    date_naissance DATE NOT NULL
);
CREATE TABLE Adresse (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(100) NOT NULL,
    rue VARCHAR(100) NOT NULL,
    ville VARCHAR(100) NOT NULL,
    code_postal VARCHAR(10) NOT NULL,
    personne_id INT,
    FOREIGN KEY (personne_id) REFERENCES Personne(id)
);
```
