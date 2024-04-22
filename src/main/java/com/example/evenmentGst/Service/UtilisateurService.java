package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.UserResponse;
import com.example.evenmentGst.Dto.UtilisateurRequest;
import com.example.evenmentGst.Entities.Role;
import com.example.evenmentGst.Entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    void updateUserRole(Long userId, Role newRole);

    List<UserResponse> getAllUtilisateur();
//    void createUtilisateurA(UtilisateurRequest utilisateurRequest);
    UserResponse getUtilisateurById(Long id);
    Utilisateur updateUtilisateur(Long id , UtilisateurRequest utilisateurRequest);
    boolean deleteUtilisateur(Long id);
}
