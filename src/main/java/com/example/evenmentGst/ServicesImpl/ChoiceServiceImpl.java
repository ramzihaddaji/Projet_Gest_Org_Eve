package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestChoice;
import com.example.evenmentGst.Dto.ResponseChoice;
import com.example.evenmentGst.Entities.Choice;
import com.example.evenmentGst.Entities.Question;
import com.example.evenmentGst.Repository.ChoiceRepository;
import com.example.evenmentGst.Repository.QuestionRepository;
import com.example.evenmentGst.Service.ChoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChoiceServiceImpl implements ChoiceService {

    private final ChoiceRepository choiceRepository;
    private final QuestionRepository questionRepository;

    @Override
    public List<ResponseChoice> getAllChoice() {
        List<Choice> choices = choiceRepository.findAll();
        List<ResponseChoice> choiceFormated = new ArrayList<>();
        for (Choice choice : choices) {
            ResponseChoice choiceF = ResponseChoice.makeChoice(choice);
            choiceFormated.add(choiceF);
        }
        return choiceFormated;
    }

    @Override
    public void createChoice(RequestChoice requestChoice) {
        Question question = questionRepository.findById(requestChoice.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + requestChoice.getQuestionId()));
        Choice choice = Choice.builder()
                .label(requestChoice.getLabel())
                .value(requestChoice.getValue())

                .build();
        choiceRepository.save(choice);
    }

    @Override
    public ResponseChoice getChoiceById(Long id) {
        Choice choice = choiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Choice not found with id: " + id));
        return ResponseChoice.makeChoice(choice);
    }

    @Override
    public Choice updateChoice(Long id, RequestChoice requestChoice) {
        Choice choice = choiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Choice not found with id: " + id));
        if (requestChoice.getLabel() != null) {
            choice.setLabel(requestChoice.getLabel());
        }
        if (requestChoice.getValue() != null) {
            choice.setValue(requestChoice.getValue());
        }
        return choiceRepository.save(choice);
    }

    @Override
    public boolean deleteChoice(Long id) {
        if (!choiceRepository.existsById(id)) {
            return false;
        }
        choiceRepository.deleteById(id);
        return true;
    }
}
