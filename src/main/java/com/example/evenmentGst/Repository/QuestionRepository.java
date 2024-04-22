package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question , Long> {
}
