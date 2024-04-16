package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement,Long> {
//    Evenement findByEvenementId(Long id);
}
