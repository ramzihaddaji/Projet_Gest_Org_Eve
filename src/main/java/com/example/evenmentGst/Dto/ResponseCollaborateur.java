package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Collaborateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCollaborateur {

    private Long id;
    private String nomSociete;
    private Instant createdAt;
    private Instant updatedAt;

    public static ResponseCollaborateur makeCollaborateur(Collaborateur collaborateur) {
        return ResponseCollaborateur.builder()
                .id(collaborateur.getId())
                .nomSociete(collaborateur.getNomSociete())
                .createdAt(collaborateur.getCreatedAt())
                .updatedAt(collaborateur.getUpdatedAt())
                .build();
    }
}
