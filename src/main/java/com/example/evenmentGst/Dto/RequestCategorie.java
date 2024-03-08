package com.example.evenmentGst.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCategorie {
    Long idCateg;
    String nom;
    private Instant createdAt;
    private Instant updatedAt;
    Long evenment_id;

}
