package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorie")
@Builder
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idCateg;
    String nom;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy="categorie")
    private List<Question> questions;


    @OneToMany(mappedBy="categorie")
    private List<Evenement> evenements;











//    @OneToMany(mappedBy = "categorie")
//    private List<Evenement> evenements; // Include the list of events
//
//    // Getter and setter for evenements
//    public List<Evenement> getEvenements() {
//        return evenements;
//    }
//
//    public void setEvenements(List<Evenement> evenements) {
//        this.evenements = evenements;
//    }

    //    @OneToMany(mappedBy = "question")
//    private Question question;
}