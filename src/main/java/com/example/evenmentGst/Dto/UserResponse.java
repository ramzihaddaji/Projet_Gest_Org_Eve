package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Role;
import com.example.evenmentGst.Entities.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse{

    private Long id;
    private String nom ;
    private String prenom ;
    private Integer ncin ;
    private Date date_naiss ;
    private String email ;
    private Role role ;

    public static UserResponse makeUserss(Utilisateur utilisateur){

        return UserResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .ncin(utilisateur.getNcin())
                .date_naiss(utilisateur.getDate_naiss())
                .email(utilisateur.getEmail())
                .role(utilisateur.getRole())
                .build();

    }
}
