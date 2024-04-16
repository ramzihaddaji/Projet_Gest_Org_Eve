package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.EvenementCollaborateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementCollaborateurRepository extends JpaRepository<EvenementCollaborateur, Long> {
    // Ajoutez ici des méthodes personnalisées pour les opérations spécifiques à la table de liaison si nécessaire
}
