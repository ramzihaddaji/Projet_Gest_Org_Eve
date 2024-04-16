package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.*;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Participant;
import com.example.evenmentGst.Entities.Utilisateur;
import com.example.evenmentGst.Repository.EvenementRepository;
import com.example.evenmentGst.Repository.ParticipantRepository;
import com.example.evenmentGst.Repository.UtlisateurRepository;
import com.example.evenmentGst.Service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final UtlisateurRepository utlisateurRepository;

    private final ParticipantRepository participantRepository;

    @Override
    public List<ResponseParticipant> getAllParticipant() {
        List<Participant> participants = participantRepository.findAll();
        List<ResponseParticipant> participantFormated = new ArrayList<>();
        for (Participant participant : participants) {
            ResponseParticipant participantF = ResponseParticipant.makeParticipant(participant);
            participantFormated.add(participantF);
        }
        return participantFormated;
    }

    @Override
    public void createParticipant(RequestParticipant requestParticipant) {
//        Utilisateur utilisateur = utlisateurRepository.findById(requestParticipant.getUser_id()).orElseThrow();

        Participant participant = Participant.builder()
                .nom(requestParticipant.getNom())
                .email(requestParticipant.getEmail())
                .Tel(requestParticipant.getTel())
                //.utilisateur(utilisateur)
                .evenements(requestParticipant.getEvenements())
                .build();
        participantRepository.save(participant);
    }

    @Override
    public ResponseParticipant getParticipantById(Long id) {
        Optional<Participant> participant = participantRepository.findById(id);
        return ResponseParticipant.makeParticipant(participant.get());
    }

    @Override
    public Participant updateParticipant(Long id, RequestParticipant requestParticipant) {
        Participant participant = participantRepository.findById(id).orElseThrow();
        if (requestParticipant.getNom() != null) {
            participant.setNom(requestParticipant.getNom());
        }
        if (requestParticipant.getEmail() != null) {
            participant.setEmail(requestParticipant.getEmail());
        }
        if (requestParticipant.getTel() != null) {
            participant.setTel(requestParticipant.getTel());
        }
        return participantRepository.save(participant);
    }

    @Override
    public boolean deleteParticipant(Long id) {
        if (!participantRepository.existsById(id)) {
            return false;
        }
        participantRepository.deleteById(id);
        return true;
    }
}
