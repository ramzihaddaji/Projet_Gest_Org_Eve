package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Repository.RepositoryEvenement;
import com.example.evenmentGst.Service.EvenementService;
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
    private RepositoryEvenement repositoryEvenement;
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
        Evenement evenement = Evenement.builder()
                .nom(requestEvenment.getNom())
                .date_debut(requestEvenment.getDate_debut())
                .date_fin(requestEvenment.getDate_fin())
                .build();
        repositoryEvenement.save(evenement);
    }

    @Override
    public ResponseEvenement getEvenementById(Long idEven) {
        Optional<Evenement> evenement = repositoryEvenement.findById(idEven);
        return ResponseEvenement.makeEvenement(evenement.get());
    }

    @Override
    public Evenement updateEvenement(Long idEven, RequestEvenment requestEvenment) {
        Evenement evenement = repositoryEvenement.findById(idEven).orElseThrow();
        if (requestEvenment.getNom() != null) {
            evenement.setNom(requestEvenment.getNom());
        }
        if (requestEvenment.getDate_debut() != null) {
            evenement.setDate_debut(requestEvenment.getDate_debut());
        }
        if (requestEvenment.getDate_fin() != null) {
            evenement.setDate_fin(requestEvenment.getDate_fin());
        }
        return repositoryEvenement.save(evenement);
    }

    @Override
    public boolean deleteEvenement(Long idEven) {
        if (!repositoryEvenement.existsById(idEven)){
            return false ;
        }
        repositoryEvenement.deleteById(idEven);
        return true;
    }
}
