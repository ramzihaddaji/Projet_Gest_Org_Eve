package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestCategorie;
import com.example.evenmentGst.Dto.RequestEvenment;
import com.example.evenmentGst.Dto.ResponseCategorie;
import com.example.evenmentGst.Dto.ResponseEvenement;
import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Evenement;

import java.util.List;

public interface CategorieService {

    List<ResponseCategorie> getAllCategorie();
    void createCategorie(RequestCategorie requestCategorie);
    ResponseCategorie getCategorieById(Long idCate);
    Categorie updateCategorie(Long idCate , RequestCategorie requestCategorie);
    boolean deleteCategorie(Long idCate);
}
