package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtlisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmail(String email);
}
