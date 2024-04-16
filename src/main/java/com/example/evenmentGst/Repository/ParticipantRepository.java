package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
