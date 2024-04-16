package com.example.evenmentGst.Controller;


import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.RequestParticipant;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Dto.ResponseParticipant;
import com.example.evenmentGst.Service.EvenementService;
import com.example.evenmentGst.Service.ParticipantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/auth/evenements/participant")
@RequiredArgsConstructor
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;
    @GetMapping("")
    public ResponseEntity<List<ResponseParticipant>> getAllParticipant(){
        List<ResponseParticipant> participants = participantService.getAllParticipant();
        return ResponseEntity.ok(participants);
    }
    @PostMapping("")
    public ResponseEntity<Object> addParticipant(@RequestBody @Valid RequestParticipant request){
        participantService.createParticipant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save succes Participant")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseParticipant> getParticipantById (@PathVariable Long id){
        return ResponseEntity.ok(participantService.getParticipantById(id));
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateParticipant(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid RequestParticipant request){
        participantService.updateParticipant(id,request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message" , "upadate succes Participant")
        );
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteParticipant(@PathVariable Long id) {
        boolean deletedParticipant = participantService.deleteParticipant(id);
        if(deletedParticipant){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message" , "delete succes Participant")
            );
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message" , "evenement existe pas Participant"));
    }

}
