package com.pfe.testapp.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OffreEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.DATE)
    private Date dateExpiration;

    private String description;
    private String localisation;
    private double salaire;
    private String typeContrat;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;
}
