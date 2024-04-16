package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Cache;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEvenement {
    Long id;
    String nom;
    String description ;
    LocalDateTime date_debut; // Update data type to LocalDateTime
    LocalDateTime date_fin;   // Update data type to LocalDateTime
    Status status;
    String lieu ;
    String frais ;
    private Instant createdAt;
    private Instant updatedAt;
//    private List<Categorie> ResponseCategories   ;
    List<ResponseCategorie> categories;

    public static ResponseEvenement makeEvenement(Evenement evenement) {

        return ResponseEvenement.builder()
                .id(evenement.getId())
                .nom(evenement.getNom())
                .description(evenement.getDescription())
                .date_debut(evenement.getDate_debut())
                .date_fin(evenement.getDate_fin())
                .lieu(evenement.getLieu())
                .status(evenement.getStatus())
                .frais(evenement.getFrais())
                .categories((List<ResponseCategorie>) evenement.getCategorie())
                .createdAt(evenement.getCreatedAt())
                .updatedAt(evenement.getUpdatedAt())
                .build();
    }
}