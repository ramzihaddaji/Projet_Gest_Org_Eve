package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Status;

import java.util.List;

public interface EvenementService {

     void updateEventStatus(Long eventId, Status newStatus) ;

    Evenement addCollaborateurToEvenement(Long evenementId, Long collaborateurId) ;
    List<ResponseEvenement> getAllEvenement();
    void createEvenement(RequestEvenment requestEvenment);
    ResponseEvenement getEvenementById(Long id);
    Evenement updateEvenement(Long idEven , RequestEvenment requestEvenment);
    boolean deleteEvenement(Long idEven);
}
