package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Inscription;
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
public class ResponseInscription {
    Long id ;
    LocalDateTime date_inscription;
    Status status;
    Long evenementId;
    Long utilisateurId;
    private Instant createdAt;
    private Instant updatedAt;
    private ResponseEvenement evenement;
    private UserResponse user;

    public static ResponseInscription makeInscription(Inscription inscription){
        return ResponseInscription.builder()
                .id(inscription.getId())
                .date_inscription(inscription.getDate_inscription())
                .status(inscription.getStatus())
                .evenement(ResponseEvenement.makeEvenement(inscription.getEvenement()))
                .user(UserResponse.makeUserss(inscription.getUtilisateur()))
                .createdAt(inscription.getCreatedAt())
                .updatedAt(inscription.getUpdatedAt())
                .build();

    }
}
