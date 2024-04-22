package com.example.evenmentGst.Controller;


import com.example.evenmentGst.Dto.RequestCommentaire;

import com.example.evenmentGst.Dto.ResponseCommentaire;

import com.example.evenmentGst.Service.CommentaireService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("api/auth/evenements/commentaire")
@RequiredArgsConstructor
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;
    @GetMapping("")
    public ResponseEntity<List<ResponseCommentaire>> getAllCommentaire(){
        List<ResponseCommentaire> Commentaire = commentaireService.getAllCommentaire();
        return ResponseEntity.ok(Commentaire);
    }
    @PostMapping("")
    public ResponseEntity<Object> addCommentaire(@RequestBody @Valid RequestCommentaire request){
        commentaireService.createCommentaire(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save succes Commentaire")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseCommentaire> getCommentaireById (@PathVariable Long id){
        return ResponseEntity.ok(commentaireService.getCommentaireById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateCommentaire(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestCommentaire request){
        commentaireService.updateCommentaire(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes Commentaire")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteCommentaire(@PathVariable Long id) {
        boolean deletedCommentaire = commentaireService.deleteCommentaire(id);
        if(deletedCommentaire){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes Commentaire")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "Commentaire existe pas"));
    }
}
