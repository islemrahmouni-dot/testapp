package com.pfe.testapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateImport;

    private String nomCv;
    private String fichier;
    private String taille;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
