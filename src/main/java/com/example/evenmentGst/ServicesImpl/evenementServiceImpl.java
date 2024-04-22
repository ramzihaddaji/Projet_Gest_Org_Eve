package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.*;
import com.example.evenmentGst.Repository.CategorieRepository;
import com.example.evenmentGst.Repository.EvenementRepository;
import com.example.evenmentGst.Repository.FormRepository;
import com.example.evenmentGst.Service.EvenementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class evenementServiceImpl implements EvenementService {
    @Autowired
    private EvenementRepository repositoryEvenement;


    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private FormRepository formRepository ;

    @Override
    public void updateEventStatus(Long eventId, Status newStatus) {
        // Retrieve the event by ID
        Optional<Evenement> optionalEvenement = repositoryEvenement.findById(eventId);

        // Check if the event exists
        if (optionalEvenement.isPresent()) {
            Evenement evenement = optionalEvenement.get();

            // Update the status
            evenement.setStatus(newStatus);

            // Save the updated event
            repositoryEvenement.save(evenement);
        } else {
            // Handle the case where the event with the given ID doesn't exist
            // You can throw an exception, log an error, or handle it based on your application's requirements
        }
    }

    @Override
    public List<ResponseEvenement> getAllEvenement() {
        List<Evenement> evenements =repositoryEvenement.findAll();
        List<ResponseEvenement> evenementFormated = new ArrayList<>();
        for (Evenement evenement : evenements){
            ResponseEvenement evenementF=ResponseEvenement.makeEvenement(evenement);
            evenementFormated.add(evenementF);
        }

        return evenementFormated;
    }

    @Override
    public void createEvenement(RequestEvenment requestEvenment) {
        Categorie categorie = categorieRepository.findById(requestEvenment.getCategorieId()).orElseThrow();
//        Form form = formRepository.findById(requestEvenment.getFormId()).orElseThrow();
        Evenement evenement = Evenement.builder()
                .nom(requestEvenment.getNom())
                .description(requestEvenment.getDescription())
                .date_debut(requestEvenment.getDate_debut())
                .date_fin(requestEvenment.getDate_fin())
                .lieu(requestEvenment.getLieu())
                .status(Status.en_cours)
                .frais(requestEvenment.getFrais())
                .categorie(categorie)
//                .form(form)
                .build();
        repositoryEvenement.save(evenement);
    }

    @Override
    public ResponseEvenement getEvenementById(Long id) {
        Optional<Evenement> evenement = repositoryEvenement.findById(id);
        return ResponseEvenement.makeEvenement(evenement.get());
    }

    @Override
    public Evenement updateEvenement(Long idEven, RequestEvenment requestEvenment) {
        Evenement evenement = repositoryEvenement.findById(idEven).orElseThrow();
        if (requestEvenment.getNom() != null) {
            evenement.setNom(requestEvenment.getNom());
        }
        if (requestEvenment.getDescription() != null) {
            evenement.setDescription(requestEvenment.getDescription());
        }
        if (requestEvenment.getDate_debut() != null) {
            evenement.setDate_debut(requestEvenment.getDate_debut());
        }
        if (requestEvenment.getDate_fin() != null) {
            evenement.setDate_fin(requestEvenment.getDate_fin());
        }
        if (requestEvenment.getLieu() != null) {
            evenement.setLieu(requestEvenment.getLieu());
        }
        if (requestEvenment.getStatus() != null) {
            evenement.setStatus(requestEvenment.getStatus());
        }
        if (requestEvenment.getFrais() != null) {
            evenement.setFrais(requestEvenment.getFrais());
        }
        return repositoryEvenement.save(evenement);
    }

    @Override
    public boolean deleteEvenement(Long id) {
        if (!repositoryEvenement.existsById(id)){
            return false ;
        }
        repositoryEvenement.deleteById(id);
        return true;
    }
}