package com.cabinet.gestioncabinetback.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime dateRDV;

    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private User doctor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=true)
    private User patient;

}
