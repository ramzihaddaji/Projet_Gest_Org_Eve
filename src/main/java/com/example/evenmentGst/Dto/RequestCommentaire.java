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
public class RequestCommentaire {
    Long id ;
     Number note;
     String commentaire;
    Long evenementId;
    private Instant createdAt;
    private Instant updatedAt;
}
