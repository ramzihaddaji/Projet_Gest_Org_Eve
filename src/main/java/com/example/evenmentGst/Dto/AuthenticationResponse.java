package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Role;
import com.example.evenmentGst.Entities.Utilisateur;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String nom ;
    private String prenom ;
    private Integer ncin ;
    private Date date_naiss ;
    private String email ;
    private Role role ;


    public static AuthenticationResponse makeUsers(Utilisateur utilisateur){
        return AuthenticationResponse.builder()
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .ncin(utilisateur.getNcin())
                .date_naiss(utilisateur.getDate_naiss())
                .email(utilisateur.getEmail())
                .role(utilisateur.getRole())
                .build();

    }
}
