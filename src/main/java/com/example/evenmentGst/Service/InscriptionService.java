package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestInscription;
import com.example.evenmentGst.Dto.ResponseInscription;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Inscription;

import java.util.List;

public interface InscriptionService {
    List<ResponseInscription> getAllInscription();
    void createInscription(RequestInscription requestInscription);
    ResponseInscription getInscriptionById(Long id);
    Inscription updateInscription(Long id , RequestInscription requestInscription);
    boolean deleteInscription(Long id);
}
