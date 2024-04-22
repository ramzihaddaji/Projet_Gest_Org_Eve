package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInscription {
    Long id ;
    LocalDateTime date_inscription;
    Status status;
    Long evenementId;
    Long utilisateurId;
    private Instant createdAt;
    private Instant updatedAt;

}
