package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestCategorie;
import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseCategorie;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Repository.CategorieRepository;
import com.example.evenmentGst.Repository.RepositoryEvenement;
import com.example.evenmentGst.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class categorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository repositoryCategorie;
    @Override
    public List<ResponseCategorie> getAllCategorie() {
        List<Categorie> categories =repositoryCategorie.findAll();
        List<ResponseCategorie> categorieFormated = new ArrayList<>();
        for (Categorie categorie : categories){
            ResponseCategorie categorieF=ResponseCategorie.makeCategorie(categorie);
            categorieFormated.add(categorieF);
        }

        return categorieFormated;
    }

    @Override
    public void createCategorie(RequestCategorie requestCategorie) {
        Categorie categorie = Categorie.builder()
                .nom(requestCategorie.getNom())
                .build();
        repositoryCategorie.save(categorie);
    }

    @Override
    public ResponseCategorie getCategorieById(Long idCate) {
        Optional<Categorie> categorie = repositoryCategorie.findById(idCate);
        return ResponseCategorie.makeCategorie(categorie.get());
    }

    @Override
    public Categorie updateCategorie(Long idCate, RequestCategorie requestCategorie) {
        Categorie categorie = repositoryCategorie.findById(idCate).orElseThrow();
        if (requestCategorie.getNom() != null) {
            categorie.setNom(requestCategorie.getNom());
        }
        return repositoryCategorie.save(categorie);
    }

    @Override
    public boolean deleteCategorie(Long idCate) {
        if (!repositoryCategorie.existsById(idCate)){
            return false ;
        }
        repositoryCategorie.deleteById(idCate);
        return true;
    }
}
