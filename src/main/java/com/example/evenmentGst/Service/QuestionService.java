package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestQuestion;
import com.example.evenmentGst.Dto.ResponseQuestion;
import com.example.evenmentGst.Entities.Question;
import jakarta.transaction.Transactional;

import java.util.List;

public interface QuestionService {

    @Transactional
    void createQuestionWithChoices(RequestQuestion request);

    List<ResponseQuestion> getAllQuestion();
    void createQuestion(RequestQuestion requestQuestion);
    ResponseQuestion getQuestionById(Long id);
    Question updateQuestion(Long id , RequestQuestion requestQuestion);
    boolean deleteQuestion(Long id);


}
