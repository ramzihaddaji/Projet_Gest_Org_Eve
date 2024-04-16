package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participant")
@Builder
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String email;
    private String Tel;

    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;

    Long user_id ;

    @ManyToMany
    @JoinTable(
            name = "evenement_participant",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "evenement_id")
    )
    private List<Evenement> evenements;

    @OneToOne(mappedBy = "participant")
    private Utilisateur utilisateur;

//    @OneToMany(mappedBy = "evenement")
//    private List<Categorie> categories ;
}
