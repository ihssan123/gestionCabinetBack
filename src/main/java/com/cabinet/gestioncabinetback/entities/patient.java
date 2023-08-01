package com.cabinet.gestioncabinetback.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Access(AccessType.FIELD)
public class patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPatient;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "numTele")
    private String numTele;
    @OneToMany(mappedBy="patient")
    private ArrayList<RDV> rdv;

}
