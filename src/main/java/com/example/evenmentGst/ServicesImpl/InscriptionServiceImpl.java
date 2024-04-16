package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestInscription;
import com.example.evenmentGst.Dto.ResponseInscription;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Inscription;
import com.example.evenmentGst.Repository.InscriptionRepository;
import com.example.evenmentGst.Service.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Override
    public List<ResponseInscription> getAllInscription() {
        List<Inscription> inscriptions =inscriptionRepository.findAll();
        List<ResponseInscription> inscriptionFormated = new ArrayList<>();
        for (Inscription inscription : inscriptions){
            ResponseInscription inscriptionF=ResponseInscription.makeInscription(inscription);
            inscriptionFormated.add(inscriptionF);
        }
        return inscriptionFormated;
    }

    @Override
    public void createInscription(RequestInscription requestInscription) {
        Inscription inscription = Inscription.builder()
//                .id(requestInscription.getId())
                .date_inscription(requestInscription.getDate_inscription())
                .status(requestInscription.getStatus())
                .build();
        inscriptionRepository.save(inscription);

    }

    @Override
    public ResponseInscription getInscriptionById(Long id) {
        Optional<Inscription> inscription = inscriptionRepository.findById(id);
        return ResponseInscription.makeInscription(inscription.get());
    }

    @Override
    public Inscription updateInscription(Long id, RequestInscription requestInscription) {
        Inscription inscription = inscriptionRepository.findById(id).orElseThrow();
        if (requestInscription.getDate_inscription() != null) {
            inscription.setDate_inscription(requestInscription.getDate_inscription());
        }
        if (requestInscription.getStatus() != null) {
            inscription.setStatus(requestInscription.getStatus());
        }

        return inscriptionRepository.save(inscription);
    }

    @Override
    public boolean deleteInscription(Long id) {
        if (!inscriptionRepository.existsById(id)){
            return false ;
        }
        inscriptionRepository.deleteById(id);
        return true;
    }
}
