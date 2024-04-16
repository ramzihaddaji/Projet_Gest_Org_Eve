package com.example.evenmentGst.Controller;


import com.example.evenmentGst.Dto.RequestParticipant;
import com.example.evenmentGst.Dto.ResponseParticipant;
import com.example.evenmentGst.Dto.UserResponse;
import com.example.evenmentGst.Dto.UtilisateurRequest;
import com.example.evenmentGst.Service.ParticipantService;
import com.example.evenmentGst.Service.UtilisateurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/utilisateurs")
//@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @GetMapping("")
    public ResponseEntity<List<UserResponse>> getAllUtilisateur(){
        List<UserResponse> utilisateurs = utilisateurService.getAllUtilisateur();
        return ResponseEntity.ok(utilisateurs);
    }

//    @PostMapping("")
//    public ResponseEntity<Object> createUtilisateur(@RequestBody @Valid UtilisateurRequest utilisateurRequest) {
//        utilisateurService.createUtilisateur(utilisateurRequest);
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                Collections.singletonMap("message", "Utilisateur créé avec succès")
//        );
//    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUtilisateurById(@PathVariable Long id) {
        UserResponse utilisateur = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateur);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<Object> updateUtilisateur(
//            @PathVariable Long id,
//            @RequestBody @Valid UtilisateurRequest utilisateurRequest) {
//        utilisateurService.updateUtilisateur(id, utilisateurRequest);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
//                Collections.singletonMap("message", "Utilisateur mis à jour avec succès")
//        );
//    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUtilisateur(
            @PathVariable Long id,
            @RequestBody @Valid UtilisateurRequest utilisateurRequest) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("message", "L'ID de l'utilisateur est null")
            );
        }
        utilisateurService.updateUtilisateur(id, utilisateurRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message", "Utilisateur mis à jour avec succès")
        );
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUtilisateur(@PathVariable Long id) {
        boolean deleted = utilisateurService.deleteUtilisateur(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    Collections.singletonMap("message", "Utilisateur supprimé avec succès")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Collections.singletonMap("message", "Utilisateur non trouvé")
        );
    }

}
