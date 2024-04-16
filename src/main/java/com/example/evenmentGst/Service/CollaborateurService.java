package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestCollaborateur;
import com.example.evenmentGst.Dto.ResponseCollaborateur;
import com.example.evenmentGst.Entities.Collaborateur;

import java.util.List;

public interface CollaborateurService {


//        List<ResponseCollaborateur> getCollaborateursByEvenementId(Long evenementId);

    List<ResponseCollaborateur> getAllCollaborateurs();
    void createCollaborateur(RequestCollaborateur requestCollaborateur);
    ResponseCollaborateur getCollaborateurById(Long id);
    Collaborateur updateCollaborateur(Long id, RequestCollaborateur requestCollaborateur);
    boolean deleteCollaborateur(Long id);
}
