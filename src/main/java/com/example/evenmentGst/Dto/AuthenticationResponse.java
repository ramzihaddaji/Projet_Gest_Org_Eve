package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Utilisateur;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;


    public static AuthenticationResponse makeUsers(Utilisateur utilisateur){
        return AuthenticationResponse.builder()
                .build();

    }
}
