package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Evenement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEvenement {
    Long idEven;
    String nom;
    DateTimeLiteralExpression.DateTime date_debut;
    DateTimeLiteralExpression.DateTime date_fin;
    private Instant createdAt;
    private Instant updatedAt;

    public static ResponseEvenement makeEvenement(Evenement evenement){
        return ResponseEvenement.builder()
                .idEven(evenement.getIdEven())
                .nom(evenement.getNom())
                .date_debut(evenement.getDate_debut())
                .date_fin(evenement.getDate_fin())
                .createdAt(evenement.getCreatedAt())
                .updatedAt(evenement.getUpdatedAt())
                .build();
    }
}
