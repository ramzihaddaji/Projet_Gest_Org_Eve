package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Choice;
import com.example.evenmentGst.Entities.Commentaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommentaire {
     Long id;
     Number note;
     String commentaire;
    Long evenementId;
    private Instant createdAt;
    private Instant updatedAt;

    private ResponseEvenement evenement;


    public static ResponseCommentaire makeCommentaire(Commentaire commentaire){
        return ResponseCommentaire.builder()
                .id(commentaire.getId())
                .note(commentaire.getNote())
                .commentaire(commentaire.getCommentaire())
                .evenement(ResponseEvenement.makeEvenement(commentaire.getEvenement()))
                .createdAt(commentaire.getCreatedAt())
                .updatedAt(commentaire.getUpdatedAt())
                .build();
    }

}
