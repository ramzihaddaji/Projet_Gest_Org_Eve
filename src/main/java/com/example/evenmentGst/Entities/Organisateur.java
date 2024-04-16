package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organisateur")
@Builder
public class Organisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id ;
//    categorie Categorie;
//    evenement Evenement ;
    String status ;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;
}
