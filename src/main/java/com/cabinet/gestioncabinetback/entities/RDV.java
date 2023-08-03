package com.cabinet.gestioncabinetback.entities;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    private Long id;
    @Column(name = "dateRDV")
    private Date dateRDV;
    @Column(name = "etat")
    private boolean etat;
    @ManyToOne
    @JoinColumn(name="idDoc", nullable=false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name="idPatient", nullable=false)
    private patient patient;
}
