package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Inscription;
import com.example.evenmentGst.Entities.Participant;
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
    String status;
    private Instant createdAt;
    private Instant updatedAt;

    public static ResponseInscription makeInscription(Inscription inscription){
        return ResponseInscription.builder()
                .id(inscription.getId())
                .date_inscription(inscription.getDate_inscription())
                .createdAt(inscription.getCreatedAt())
                .updatedAt(inscription.getUpdatedAt())
                .build();

    }
}
