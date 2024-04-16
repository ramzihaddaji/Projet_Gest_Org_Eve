package com.example.evenmentGst.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    private boolean expired;
    private boolean revoked;
    //    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;


}
