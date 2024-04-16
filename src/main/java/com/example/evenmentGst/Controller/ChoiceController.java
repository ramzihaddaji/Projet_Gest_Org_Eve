package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Dto.RequestCategorie;
import com.example.evenmentGst.Dto.RequestChoice;
import com.example.evenmentGst.Dto.ResponseCategorie;
import com.example.evenmentGst.Dto.ResponseChoice;
import com.example.evenmentGst.Service.CategorieService;
import com.example.evenmentGst.Service.ChoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/choice")
@RequiredArgsConstructor
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;
    @GetMapping("")
    public ResponseEntity<List<ResponseChoice>> getAllChoice(){
        List<ResponseChoice> categories = choiceService.getAllChoice();
        return ResponseEntity.ok(categories);
    }
    @PostMapping("")
    public ResponseEntity<Object> addChoice(@RequestBody @Valid RequestChoice request){
        choiceService.createChoice(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save succes Choice")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseChoice> getChoiceById (@PathVariable Long id){
        return ResponseEntity.ok(choiceService.getChoiceById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateChoice(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestChoice request){
        choiceService.updateChoice(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes Choice")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteChoice(@PathVariable Long id) {
        boolean deletedChoice = choiceService.deleteChoice(id);
        if(deletedChoice){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes Choice")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "Choice existe pas"));
    }
}
