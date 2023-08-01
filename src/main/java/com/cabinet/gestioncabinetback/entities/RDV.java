package com.cabinet.gestioncabinetback.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Access(AccessType.FIELD)
public class RDV {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idRDV;
    @Column(name = "dateRDV")
    private Date dateRDV;
    @Column(name = "etat")
    private boolean etat;
    @ManyToOne
    @JoinColumn(name="idDoc", nullable=false)
    private doctor doctor;
    @ManyToOne
    @JoinColumn(name="idPatient", nullable=false)
    private patient patient;
}
