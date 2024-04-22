package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.Status;
import com.example.evenmentGst.Service.EvenementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/auth/evenements/evenement")
@RequiredArgsConstructor
public class EvenementController {
    @Autowired
    private EvenementService evenementService;

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateEventStatus(@PathVariable Long id, @RequestBody Map<String, String> statusMap) {
        String statusString = statusMap.get("status");
        Status newStatus = null;
        try {
            newStatus = Status.valueOf(statusString.toLowerCase()); // Convert the string to lowercase before converting to enum
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Invalid status value"));
        }

        evenementService.updateEventStatus(id, newStatus);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<ResponseEvenement>> getAllEvenement(){
        List<ResponseEvenement> evenements = evenementService.getAllEvenement();
        return ResponseEntity.ok(evenements);
    }
    @PostMapping("")
    public ResponseEntity<Object> addEvenement(@RequestBody @Valid RequestEvenment request){
        evenementService.createEvenement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save succes")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseEvenement> getEvenementById (@PathVariable Long id){
        return ResponseEntity.ok(evenementService.getEvenementById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateEvenement(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestEvenment request){
        evenementService.updateEvenement(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteEvenement(@PathVariable Long id) {
        boolean deletedEvenement = evenementService.deleteEvenement(id);
        if(deletedEvenement){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "evenement existe pas"));
    }




}
