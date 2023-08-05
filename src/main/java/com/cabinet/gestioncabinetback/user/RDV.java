package com.cabinet.gestioncabinetback.user;
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
    private Long id;
    @Column(name = "dateRDV")
    private Date dateRDV;
    @Column(name = "etat")
    private boolean etat;
    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;

}
