package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "utlisateur")
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    String nom;

    @NotNull
    String prenom;

    Integer ncin;

    @NotNull
    @Temporal(TemporalType.DATE)
    Date date_naiss;

    @NotNull
    @Email
    String email;

    String password;

    @Enumerated(EnumType.STRING)
    private Role role ;
//    @OneToMany(mappedBy = "utlisateur")
//    private List<Token> tokens;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Token> tokens;

    @OneToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    private Participant participant;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role != null) {
            return List.of(new SimpleGrantedAuthority(role.name()));
        } else {
            // If the role is null, return an empty list of authorities
            return Collections.emptyList();
        }
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
