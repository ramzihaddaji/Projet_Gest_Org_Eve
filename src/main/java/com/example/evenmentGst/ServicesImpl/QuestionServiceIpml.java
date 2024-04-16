package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestChoice;
import com.example.evenmentGst.Dto.RequestQuestion;
import com.example.evenmentGst.Dto.ResponseQuestion;
import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Choice;
import com.example.evenmentGst.Entities.InputType;
import com.example.evenmentGst.Entities.Question;
import com.example.evenmentGst.Repository.CategorieRepository;
import com.example.evenmentGst.Repository.ChoiceRepository;
import com.example.evenmentGst.Repository.QuestionRepository;
import com.example.evenmentGst.Service.QuestionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceIpml implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    private final CategorieRepository categorieRepository;
    @Autowired // Ajoutez cette annotation
    private ChoiceRepository choiceRepository ;

    @Override
    @Transactional
    public void createQuestionWithChoices(RequestQuestion request) {
        // Créer la question
        Question question = new Question();
        question.setTitle(request.getTitle());
        question.setInputType(request.getInputType());

        // Enregistrer la question en base de données
        question = questionRepository.save(question);

        // Si la question est de type RADIO_BUTTON, créer et lier les choix à la question
        if (request.getInputType() == InputType.RADIO_BUTTON && request.getChoices() != null) {
            for (RequestChoice choice : request.getChoices()) {
                Choice newChoice = new Choice();
                newChoice.setLabel(choice.getLabel());
                newChoice.setValue(choice.getValue());
                newChoice.setQuestion(question);
                choiceRepository.save(newChoice);
            }
        }
    }




    @Override
    public List<ResponseQuestion> getAllQuestion() {
        List<Question> questions =questionRepository.findAll();
        List<ResponseQuestion> questionFormated = new ArrayList<>();
        for (Question question : questions){
            ResponseQuestion questionF=ResponseQuestion.makeQuestion(question);
            questionFormated.add(questionF);
        }

        return questionFormated;
    }

    @Override
    public void createQuestion(RequestQuestion requestQuestion) {
        Categorie categorie = categorieRepository.findById(requestQuestion.getCategorieId()).orElseThrow();
        Question question = Question.builder()
                .title(requestQuestion.getTitle())
                .inputType(requestQuestion.getInputType())
                .categorie(categorie)
//                .Tel(requestParticipant.getTel())
//                .utilisateur(utilisateur)
                .build();
        questionRepository.save(question);

    }
//v1
//    @Override
//    public ResponseQuestion getQuestionById(Long id) {
//        Optional<Question> question = questionRepository.findById(id);
//        return ResponseQuestion.makeQuestion(question.get());
//    }

    @Override
    public ResponseQuestion getQuestionById(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            return ResponseQuestion.makeQuestion(optionalQuestion.get());
        } else {
            // Gérer le cas où la question n'est pas trouvée, par exemple, en renvoyant null ou en lançant une exception
            throw new EntityNotFoundException("Question not found with id: " + id);
        }
    }


    @Override
    public Question updateQuestion(Long id, RequestQuestion requestQuestion) {
        Question question = questionRepository.findById(id).orElseThrow();
        if (requestQuestion.getTitle() != null) {
            question.setTitle(requestQuestion.getTitle());
        }
        if (requestQuestion.getInputType() != null) {
            question.setInputType(requestQuestion.getInputType());
        }
        return questionRepository.save(question);
    }

    @Override
    public boolean deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)){
            return false ;
        }
        questionRepository.deleteById(id);
        return true;
    }
}
