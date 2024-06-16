package com.example.evenmentGst.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evenement")
@Builder
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String nom;
    String description ;
    @Column(name = "date_debut")
    LocalDateTime date_debut; // Update data type to LocalDateTime
    @Column(name = "date_fin")
    LocalDateTime date_fin;
    String lieu ;
     Status status;
    String frais ;

    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy="evenement")
    private List<Inscription> inscriptions;

    @OneToOne
    @JoinColumn(name = "facture_id", referencedColumnName = "id")
    private Facture facture;

    @OneToMany(mappedBy = "evenement")
    private List<Commentaire> commentaires;

    @OneToOne
    @JoinColumn(name = "formulaire_id")
    private Form formulaire;

//
//    @ManyToMany
//    private List<Participant> participants;
//
//
////
////    @ManyToOne
////    @JoinColumn(name="evenement_id")
////    private Evenement evenement;
//
//    @ManyToOne
//    @JoinColumn(name = "categorie_id")
//    private Categorie categorie;


//
//
//
//
//@ManyToMany(cascade = { CascadeType.ALL })
//@JoinTable(
//        name = "evenement_collaborateur",
//        joinColumns = { @JoinColumn(name = "evenement_id") },
//        inverseJoinColumns = { @JoinColumn(name = "collaborateur_id") }
//)
//private Set<Collaborateur> collaborateurs = new HashSet<>();
//
//
//
//    @OneToOne(mappedBy = "evenement")
//    private Form form;

    //    @ManyToMany
//    @JoinTable(
//            name = "evenement_collaborateur",
//            joinColumns = @JoinColumn(name = "evenement_id"),
//            inverseJoinColumns = @JoinColumn(name = "collaborateur_id"))
//    private List<Collaborateur> collaborateurs;

}