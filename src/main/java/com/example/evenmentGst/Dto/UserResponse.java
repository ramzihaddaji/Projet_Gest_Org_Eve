package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Role;
import com.example.evenmentGst.Entities.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse{


    private String nom ;
    private String prenom ;
    private String ncin ;
    private String date_naiss ;
    private String email ;
    private String password ;
    private Role role ;

    public static UserResponse makeUserss(Utilisateur utilisateur){

        return UserResponse.builder()
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .ncin(String.valueOf(utilisateur.getNcin()))
                .date_naiss(String.valueOf(utilisateur.getDate_naiss()))
                .email(utilisateur.getEmail())
//                .password(utilisateur.getPassword())
                .role(utilisateur.getRole())
                .build();

    }
}
