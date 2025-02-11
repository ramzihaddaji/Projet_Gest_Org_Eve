package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvenment {
    String nom;
    String description ;
    LocalDateTime date_debut;
    LocalDateTime date_fin;
    String lieu ;
    Status status;
    String frais ;
    Long categorieId;
//    Long FormId;

}