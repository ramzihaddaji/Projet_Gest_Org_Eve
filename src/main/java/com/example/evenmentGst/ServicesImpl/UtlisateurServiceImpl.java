package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.UserResponse;
import com.example.evenmentGst.Dto.UtilisateurRequest;
import com.example.evenmentGst.Entities.*;
import com.example.evenmentGst.Repository.UtlisateurRepository;
import com.example.evenmentGst.Service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtlisateurServiceImpl implements UtilisateurService {
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private UtlisateurRepository utlisateurRepository;

    @Override
    public void updateUserRole(Long userId, Role newRole) {
        // Retrieve the event by ID
        Optional<Utilisateur> optionalUtilisateur = utlisateurRepository.findById(userId);

        // Check if the event exists
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();

            // Update the status
            utilisateur.setRole(newRole);

            // Save the updated event
            utlisateurRepository.save(utilisateur);
        }
    }


    @Override
    public List<UserResponse> getAllUtilisateur() {
        List<Utilisateur> utilisateurs =utlisateurRepository.findAll();
        List<UserResponse> utilisateurFormated = new ArrayList<>();
        for (Utilisateur utilisateur : utilisateurs){
            UserResponse utilisateurF=UserResponse.makeUserss(utilisateur);
            utilisateurFormated.add(utilisateurF);
        }

        return utilisateurFormated;
    }

//    @Override
//    public void createUtilisateurA(UtilisateurRequest utilisateurRequest) {
//        Utilisateur utilisateur = Utilisateur.builder()
//                .nom(utilisateurRequest.getNom())
//                .prenom(utilisateurRequest.getPrenom())
//                .email(utilisateurRequest.getEmail())
//                .password(passwordEncoder.encode(utilisateurRequest.getPassword()))
//                .ncin(Integer.valueOf(utilisateurRequest.getNcin()))
//                .date_naiss(utilisateurRequest.getDate_naiss())
//                .role(Role.participant)
//                .build();
//        utlisateurRepository.save(utilisateur);
//    }


    @Override
    public UserResponse getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateur = utlisateurRepository.findById(id);
        return UserResponse.makeUserss(utilisateur.get());
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, UtilisateurRequest utilisateurRequest) {
        Utilisateur utilisateur = utlisateurRepository.findById(id).orElseThrow();
        if (utilisateurRequest.getNom() != null) {
            utilisateur.setNom(utilisateurRequest.getNom());
        }
        if (utilisateurRequest.getPrenom() != null) {
            utilisateur.setPrenom(utilisateurRequest.getPrenom());
        }
        if (utilisateurRequest.getDate_naiss() != null) {
            utilisateur.setDate_naiss(utilisateurRequest.getDate_naiss());
        }
        if (utilisateurRequest.getNcin() != null) {
            utilisateur.setNcin(Integer.valueOf(utilisateurRequest.getNcin()));
        }
        if (utilisateurRequest.getEmail() != null) {
            utilisateur.setEmail(utilisateurRequest.getEmail());
        }
//        if (utilisateurRequest.getPassword() != null) {
//            utilisateur.setPassword(passwordEncoder.encode(utilisateurRequest.getPassword()));
//
//        }
        if (utilisateurRequest.getRole() != null) {
            utilisateur.setRole(utilisateurRequest.getRole());
        }

        return utlisateurRepository.save(utilisateur);
    }

    @Override
    public boolean deleteUtilisateur(Long id) {
        if (!utlisateurRepository.existsById(id)){
            return false ;
        }
        utlisateurRepository.deleteById(id);
        return true;
    }
    }

