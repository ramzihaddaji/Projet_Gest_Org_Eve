package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Participant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseParticipant {
    Long id ;
    String nom;
    String email;
    String Tel ;
    private Instant createdAt;
    private Instant updatedAt;
    Long user_id ;
    // Nouveau champ pour l'utilisateur associé
//    private UserResponse utilisateur;
    private List<Evenement> ResponseEvenements   ;

    public static ResponseParticipant makeParticipant(Participant participant){
//        UserResponse userResponse = UserResponse.makeUserss(participant.getUtilisateur());
        return ResponseParticipant.builder()
                .id(participant.getId())
                .nom(participant.getNom())
                .email(participant.getEmail())
                .Tel(participant.getTel())
                .createdAt(participant.getCreatedAt())
                .updatedAt(participant.getCreatedAt())
                .ResponseEvenements(participant.getEvenements())
//                .utilisateur(UserResponse.makeUserss(participant.getUtilisateur()))
//                .evenement(ResponseEvenement.makeEvenement(participant.getEvenements()))
                .build();

    }
}
