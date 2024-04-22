package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {

}
