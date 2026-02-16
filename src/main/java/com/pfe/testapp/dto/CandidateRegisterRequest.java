package com.pfe.testapp.dto;

import com.pfe.testapp.entities.Role;

public class CandidateRegisterRequest {
    private String email;
    private String nom;
    private String password;
    private String numTelephone;
    private Role role;

    public CandidateRegisterRequest() {
    }

    public CandidateRegisterRequest(String email, String nom, String password, String numTelephone, Role role) {
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.numTelephone = numTelephone;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}