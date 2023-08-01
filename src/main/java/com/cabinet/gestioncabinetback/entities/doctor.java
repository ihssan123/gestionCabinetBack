package com.cabinet.gestioncabinetback.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Access(AccessType.FIELD)
public class doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idDoc;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "specialite")
    private String specialite;
    @Column(name = "numTele")
    private String numTele;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "diplome")
    private String diplome;
    @OneToMany(mappedBy="doctor")
    private ArrayList<RDV> rdv;

}
