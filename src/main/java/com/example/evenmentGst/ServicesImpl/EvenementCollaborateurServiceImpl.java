package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Entities.Collaborateur;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.EvenementCollaborateur;
import com.example.evenmentGst.Repository.CollaborateurRepository;
import com.example.evenmentGst.Repository.EvenementCollaborateurRepository;
import com.example.evenmentGst.Repository.EvenementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EvenementCollaborateurServiceImpl {
    private  EvenementRepository evenementRepository;
    private  CollaborateurRepository collaborateurRepository;
    private  EvenementCollaborateurRepository evenementCollaborateurRepository;

    public void addCollaborateurToEvenement(Long idEvenement, Long idCollaborateur, String description) {
        // Vérifiez si l'événement et le collaborateur existent dans votre base de données
        Evenement evenement = evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new EntityNotFoundException("Evenement not found with id: " + idEvenement));
        Collaborateur collaborateur = collaborateurRepository.findById(idCollaborateur)
                .orElseThrow(() -> new EntityNotFoundException("Collaborateur not found with id: " + idCollaborateur));

        // Créez une nouvelle entrée dans la table de liaison avec l'ID de l'événement, l'ID du collaborateur et la description
        EvenementCollaborateur evenementCollaborateur = new EvenementCollaborateur();
        evenementCollaborateur.setEvenement(evenement);
        evenementCollaborateur.setCollaborateur(collaborateur);
        evenementCollaborateur.setDescription(description);

        // Enregistrez la nouvelle entrée dans la table de liaison
        evenementCollaborateurRepository.save(evenementCollaborateur);
    }
}
