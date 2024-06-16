package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facture")
@Builder
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    Long prix_ticket;
    LocalDateTime dateFacturation ;

    @OneToOne(mappedBy = "facture")
    private Evenement evenement;






}
