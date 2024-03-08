package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Evenement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCategorie {
    Long idCateg;
    String nom;
    private Instant createdAt;
    private Instant updatedAt;
    ResponseEvenement evenement;

    public static ResponseCategorie makeCategorie(Categorie categorie) {
        return ResponseCategorie.builder()
                .idCateg(categorie.getIdCateg())
                .nom(categorie.getNom())
                .createdAt(categorie.getCreatedAt())
                .updatedAt(categorie.getUpdatedAt())
                .build();
    }
}
