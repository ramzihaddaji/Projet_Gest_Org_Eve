package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Evenement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCategorie {
    Long idCateg;
    String nom;
//    Long evnementId;
    private Instant createdAt;
    private Instant updatedAt;
//    List<ResponseEvenement> evenements;


    public static ResponseCategorie makeCategorie(Categorie categorie) {
        return ResponseCategorie.builder()
                .idCateg(categorie.getId())
                .nom(categorie.getNom())
                .createdAt(categorie.getCreatedAt())
                .updatedAt(categorie.getUpdatedAt())
                .build();
    }
}