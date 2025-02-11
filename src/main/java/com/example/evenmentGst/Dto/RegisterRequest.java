package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom;
    private String prenom;
    private Integer ncin;
    private Date date_naiss ;
    private String email;
    private String password;
    private Role role;
}
