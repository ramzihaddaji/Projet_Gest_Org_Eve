package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestCollaborateur;
import com.example.evenmentGst.Dto.ResponseCollaborateur;
import com.example.evenmentGst.Entities.Collaborateur;
import com.example.evenmentGst.Repository.CollaborateurRepository;
import com.example.evenmentGst.Service.CollaborateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollaborateurServiceImpl implements CollaborateurService {

    @Autowired
    private final CollaborateurRepository collaborateurRepository;

//    @Override
//    public List<ResponseCollaborateur> getCollaborateursByEvenementId(Long evenementId) {
//        List<Collaborateur> collaborateurs = collaborateurRepository.findByEvenementsId(evenementId);
//        return collaborateurs.stream()
//                .map(ResponseCollaborateur::makeCollaborateur)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<ResponseCollaborateur> getAllCollaborateurs() {
        List<Collaborateur> collaborateurs = collaborateurRepository.findAll();
        List<ResponseCollaborateur> collaborateurFormatted = new ArrayList<>();
        for (Collaborateur collaborateur : collaborateurs) {
            ResponseCollaborateur collaborateurF = ResponseCollaborateur.makeCollaborateur(collaborateur);
            collaborateurFormatted.add(collaborateurF);
        }
        return collaborateurFormatted;
    }

    @Override
    public void createCollaborateur(RequestCollaborateur requestCollaborateur) {
        Collaborateur collaborateur = Collaborateur.builder()
                .nomSociete(requestCollaborateur.getNomSociete())
                .build();
        collaborateurRepository.save(collaborateur);
    }

    @Override
    public ResponseCollaborateur getCollaborateurById(Long id) {
        Optional<Collaborateur> collaborateur = collaborateurRepository.findById(id);
        return ResponseCollaborateur.makeCollaborateur(collaborateur.orElseThrow());
    }

    @Override
    public Collaborateur updateCollaborateur(Long id, RequestCollaborateur requestCollaborateur) {
        Collaborateur collaborateur = collaborateurRepository.findById(id).orElseThrow();
        if (requestCollaborateur.getNomSociete() != null) {
            collaborateur.setNomSociete(requestCollaborateur.getNomSociete());
        }
        return collaborateurRepository.save(collaborateur);
    }

    @Override
    public boolean deleteCollaborateur(Long id) {
        if (!collaborateurRepository.existsById(id)) {
            return false;
        }
        collaborateurRepository.deleteById(id);
        return true;
    }


}
