package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement,Long> {
//    Evenement findByEvenementId(Long id);
}
