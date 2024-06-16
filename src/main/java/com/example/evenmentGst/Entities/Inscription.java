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
@Table(name = "inscription")
@Builder
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
    LocalDateTime date_inscription;
    Status status ;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "utlisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "inscription")
    private List<Participant> participants;



}
