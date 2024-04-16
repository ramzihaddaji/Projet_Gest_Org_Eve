package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evenement_collaborateur")
public class EvenementCollaborateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evenement_id", referencedColumnName = "id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "collaborateur_id", referencedColumnName = "id")
    private Collaborateur collaborateur;

    @Column(name = "description")
    private String description;

    // Getters and setters
}
