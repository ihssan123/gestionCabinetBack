package com.cabinet.gestioncabinetback.user;

import com.cabinet.gestioncabinetback.token.Token;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "nom")
    private String firstname;
    @Column(name = "prenom")
    private String lastname;
    @Column(name = "email", unique = true )
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "specialite")
    private String speciality;
    @Column(name = "numTele")
    private String phoneNumber;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "diplome")
    private String diplome;
    @JsonIgnore
    @OneToMany(mappedBy="doctor")
    private List<RDV> RDVDoc;
    @JsonIgnore
    @OneToMany(mappedBy="patient")
    private List<RDV> RDVPat;


    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
