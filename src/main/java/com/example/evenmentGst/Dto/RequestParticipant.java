package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Evenement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestParticipant {

    String nom;
    String email;
    String Tel ;
    Long user_id ;
    List<Evenement> evenements;

}
