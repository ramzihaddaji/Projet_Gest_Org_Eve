package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;
import java.time.LocalDateTime;

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
    Long categorieId;
//    Long form_id;
    private Instant createdAt;
    private Instant updatedAt;
//    private List<Collaborateur> ResponseCollaborateurs   ;
//    private List<Collaborateur> collaborateurs;
    private ResponseCategorie categories;
//    private ResponseForm form;
//    private Categorie categories;



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
                .createdAt(evenement.getCreatedAt())
                .updatedAt(evenement.getUpdatedAt())
                .categories(ResponseCategorie.makeCategorie(evenement.getCategorie()))
//                .form(ResponseForm.makeForm(evenement.getFormulaire()))
//                .categories((List<ResponseCategorie>) evenement.getCategorie())
//                .categories(evenement.getCategorie())
//                .ResponseCollaborateurs(evenement.getCollaborateurs())
//                .collaborateurs(evenement.getCollaborateurs())
                .build();
    }
}