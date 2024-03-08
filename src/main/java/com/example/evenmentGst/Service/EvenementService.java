package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.Evenement;

import java.util.List;

public interface EvenementService {
    List<ResponseEvenement> getAllEvenement();
    void createEvenement(RequestEvenment requestEvenment);
    ResponseEvenement getEvenementById(Long idEven);
    Evenement updateEvenement(Long idEven , RequestEvenment requestEvenment);
    boolean deleteEvenement(Long idEven);
}
