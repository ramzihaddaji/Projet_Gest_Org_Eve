package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Entities.Question;

import com.example.evenmentGst.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Méthode pour récupérer toutes les questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Méthode pour ajouter une nouvelle question
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Méthode pour récupérer une question par son ID
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    // Méthode pour supprimer une question par son ID
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

    // Méthode pour mettre à jour une question existante
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }
}
