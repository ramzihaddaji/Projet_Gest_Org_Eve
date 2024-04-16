package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Dto.RequestCategorie;
import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseCategorie;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Service.CategorieService;
import com.example.evenmentGst.Service.EvenementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/categorie")
@RequiredArgsConstructor
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("")
    public ResponseEntity<List<ResponseCategorie>> getAllCategorie(){
        List<ResponseCategorie> categories = categorieService.getAllCategorie();
        return ResponseEntity.ok(categories);
    }
    @PostMapping("")
    public ResponseEntity<Object> addCategorie(@RequestBody @Valid RequestCategorie request){
        categorieService.createCategorie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save succes Categorie")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseCategorie> getCategorieById (@PathVariable Long id){
        return ResponseEntity.ok(categorieService.getCategorieById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateCategorie(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestCategorie request){
        categorieService.updateCategorie(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes Categorie")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteCategorie(@PathVariable Long id) {
        boolean deletedCategorie = categorieService.deleteCategorie(id);
        if(deletedCategorie){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes Categorie")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "Categorie existe pas"));
    }
}
