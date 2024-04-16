package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "collaborateur")
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomSociete;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;

//    @ManyToMany(mappedBy = "collaborateurs")
//    private List<Evenement> evenements;

    @ManyToMany(mappedBy = "collaborateurs")
    private Set<Evenement> evenements = new HashSet<>();

}
