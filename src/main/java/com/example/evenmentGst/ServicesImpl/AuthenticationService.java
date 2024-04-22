package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Config.EmailAlreadyExistsException;
import com.example.evenmentGst.Config.JwtService;
import com.example.evenmentGst.Dto.*;
import com.example.evenmentGst.Entities.*;
import com.example.evenmentGst.Repository.TokenRepository;
import com.example.evenmentGst.Repository.UtlisateurRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtlisateurRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


public List<UserResponse> getAllUsers() {
    List<Utilisateur> users = repository.findAll();
    List<UserResponse> userFormated = new ArrayList<>();
        for (Utilisateur utilisateur : users){
            UserResponse usersF=UserResponse.makeUserss(utilisateur);
            userFormated.add(usersF);
        }

        return userFormated;
    }
public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user); // Génère un nouveau token à chaque authentification
    // Supprime les anciens tokens de l'utilisateur s'il en existe
    revokeAllUserTokens(user);
    saveUserToken(user,jwtToken);
    return AuthenticationResponse.builder()
            .nom(user.getNom())
            .prenom(user.getPrenom())
            .email(user.getEmail())
            .ncin(user.getNcin())
            .date_naiss(user.getDate_naiss())
            .role(user.getRole())
            .token(jwtToken)
            .build();
}


    public AuthenticationResponse register(RegisterRequest request) {
        // Vérifie si l'e-mail existe déjà
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("L'e-mail existe déjà.");
        }


        // Créez l'utilisateur
        var utilisateur = Utilisateur.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .ncin(request.getNcin())
                .date_naiss(request.getDate_naiss())
                .role(Role.utilisateur)
                .build();
        var savedUser = repository.save(utilisateur);

        // Générer le token JWT
        var jwtToken = jwtService.generateToken(savedUser);

        // Enregistrez le token pour l'utilisateur
        saveUserToken(savedUser, jwtToken);

        // Retourner la réponse d'authentification avec le token
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    private void revokeAllUserTokens(Utilisateur utilisateur){
        var validUserTokens = tokenRepository.findAllValidTokensByUser(utilisateur.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(t -> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(Utilisateur user, String jwtToken) {
        var token= Token.builder()
                .utilisateur(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

}
