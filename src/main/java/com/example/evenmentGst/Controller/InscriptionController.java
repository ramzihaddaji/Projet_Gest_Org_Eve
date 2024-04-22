package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Dto.RequestInscription;
import com.example.evenmentGst.Dto.ResponseInscription;
import com.example.evenmentGst.Service.InscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/inscription")
@RequiredArgsConstructor
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;
    @GetMapping("")
    public ResponseEntity<List<ResponseInscription>> getAllInscription(){
        List<ResponseInscription> inscriptions = inscriptionService.getAllInscription();
        return ResponseEntity.ok(inscriptions);
    }
    @PostMapping("")
    public ResponseEntity<Object> addInscription(@RequestBody @Valid RequestInscription request){
        inscriptionService.createInscription(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save succes Inscription")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseInscription> getInscriptionById (@PathVariable Long id){
        return ResponseEntity.ok(inscriptionService.getInscriptionById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateInscription(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestInscription request){
        inscriptionService.updateInscription(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes Inscription")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteInscription(@PathVariable Long id) {
        boolean deleteInscription = inscriptionService.deleteInscription(id);
        if(deleteInscription){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes Inscription")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "evenement existe pas Inscription"));
    }
}
