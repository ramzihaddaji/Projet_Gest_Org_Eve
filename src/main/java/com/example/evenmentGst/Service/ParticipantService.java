package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.RequestParticipant;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Dto.ResponseParticipant;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Participant;

import java.util.List;

public interface ParticipantService {
    List<ResponseParticipant> getAllParticipant();
    void createParticipant(RequestParticipant requestParticipant);
    ResponseParticipant getParticipantById(Long id);
    Participant updateParticipant(Long id , RequestParticipant requestParticipant);
    boolean deleteParticipant(Long id);
}
