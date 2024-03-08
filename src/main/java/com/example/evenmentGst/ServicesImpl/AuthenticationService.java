package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Config.JwtService;
import com.example.evenmentGst.Dto.AuthenticationRequest;
import com.example.evenmentGst.Dto.AuthenticationResponse;
import com.example.evenmentGst.Dto.RegisterRequest;
import com.example.evenmentGst.Entities.Role;
import com.example.evenmentGst.Entities.Token;
import com.example.evenmentGst.Entities.TokenType;
import com.example.evenmentGst.Entities.Utilisateur;
import com.example.evenmentGst.Repository.TokenRepository;
import com.example.evenmentGst.Repository.UtlisateurRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtlisateurRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//        var user = repository.findByEmail(request.getEmail()).orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//        saveUserToken(user,jwtToken);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }
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
            .token(jwtToken)
            .build();
}


    public AuthenticationResponse register(RegisterRequest request) {

        var utlisateur = Utilisateur.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.client)
                .build();
        var savedUser = repository.save(utlisateur);
        var jwtToken = jwtService.generateToken(utlisateur);
        saveUserToken(savedUser, jwtToken);
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
