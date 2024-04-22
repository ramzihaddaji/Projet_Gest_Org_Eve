package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire , Long> {
}
