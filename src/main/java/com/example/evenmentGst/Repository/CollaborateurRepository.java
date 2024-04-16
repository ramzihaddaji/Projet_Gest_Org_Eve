package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaborateurRepository extends JpaRepository<Collaborateur , Long> {
//    List<Collaborateur> findByEvenementsId(Long evenementId);
}
