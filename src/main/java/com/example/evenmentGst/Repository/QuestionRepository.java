package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question , Long> {
}
