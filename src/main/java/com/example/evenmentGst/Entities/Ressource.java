package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ressource")
@Builder
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String ressource;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;
}
