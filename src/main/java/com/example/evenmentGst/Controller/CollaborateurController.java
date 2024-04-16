package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Dto.RequestCollaborateur;
import com.example.evenmentGst.Dto.ResponseCollaborateur;
import com.example.evenmentGst.Service.CollaborateurService;
import com.example.evenmentGst.ServicesImpl.EvenementCollaborateurServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/collaborateur")
@RequiredArgsConstructor
public class CollaborateurController {

    private final CollaborateurService collaborateurService;

    @GetMapping("")
    public ResponseEntity<List<ResponseCollaborateur>> getAllCollaborateurs() {
        List<ResponseCollaborateur> collaborateurs = collaborateurService.getAllCollaborateurs();
        return ResponseEntity.ok(collaborateurs);
    }

    @PostMapping("")
    public ResponseEntity<Object> addCollaborateur(@RequestBody @Valid RequestCollaborateur request) {
        collaborateurService.createCollaborateur(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "Save successful for Collaborateur")
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseCollaborateur> getCollaborateurById(@PathVariable Long id) {
        return ResponseEntity.ok(collaborateurService.getCollaborateurById(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateCollaborateur(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestCollaborateur request) {
        collaborateurService.updateCollaborateur(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message", "Update successful for Collaborateur")
        );
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteCollaborateur(@PathVariable Long id) {
        boolean deletedCollaborateur = collaborateurService.deleteCollaborateur(id);
        if (deletedCollaborateur) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "Delete successful for Collaborateur")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message", "Collaborateur does not exist")
        );
    }

}
