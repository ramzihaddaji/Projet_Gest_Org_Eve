package com.example.evenmentGst.Controller;


import com.example.evenmentGst.Dto.RequestQuestion;
import com.example.evenmentGst.Dto.ResponseQuestion;
import com.example.evenmentGst.Entities.InputType;
import com.example.evenmentGst.Service.CategorieService;
import com.example.evenmentGst.Service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/questions")
@RequiredArgsConstructor
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("")
    public ResponseEntity<List<ResponseQuestion>> getAllQuestion(){
        List<ResponseQuestion> questions = questionService.getAllQuestion();
        return ResponseEntity.ok(questions);
    }

@PostMapping("")
public ResponseEntity<Object> addQuestion(@RequestBody @Valid RequestQuestion request){
    if (request.getInputType() == InputType.RADIO_BUTTON) {
        if (request.getChoices() == null || request.getChoices().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("message", "Choices are required for buttonRadio type")
            );
        }
    }
    questionService.createQuestionWithChoices(request); // Utiliser la nouvelle méthode pour créer une question avec des choix
    return ResponseEntity.status(HttpStatus.CREATED).body(
            Collections.singletonMap("message","save succes Question")
    );
}

    @GetMapping("{id}")
    public ResponseEntity<ResponseQuestion> getQuestionById (@PathVariable Long id){
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateQuestion(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestQuestion request){
        questionService.updateQuestion(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes Question")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteQuestion(@PathVariable Long id) {
        boolean deletedQuestion = questionService.deleteQuestion(id);
        if(deletedQuestion){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes Question")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "evenement existe pas Question"));
    }
}