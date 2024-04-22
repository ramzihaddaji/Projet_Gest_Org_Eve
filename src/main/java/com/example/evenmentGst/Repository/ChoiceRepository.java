package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice , Long> {
}
