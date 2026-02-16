package com.pfe.testapp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

    private String numTelephone;
    private String posteRecherche;
    private String localisation;
    private int experience;

    public Candidate() {
        super();
    }

    public Candidate(String email, String nom, String password, Role role, Boolean statutCompte,
                     String numTelephone, String posteRecherche, String localisation, int experience) {
        super();
        setEmail(email);
        setPassword(password);
        setNom(nom);
        setRole(role);
        setStatutCompte(statutCompte);
        this.numTelephone = numTelephone;
        this.posteRecherche = posteRecherche;
        this.localisation = localisation;
        this.experience = experience;
    }

    // Getters and Setters
    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getPosteRecherche() {
        return posteRecherche;
    }

    public void setPosteRecherche(String posteRecherche) {
        this.posteRecherche = posteRecherche;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}