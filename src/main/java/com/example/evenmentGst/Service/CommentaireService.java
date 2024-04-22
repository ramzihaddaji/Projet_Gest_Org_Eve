package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestCommentaire;
import com.example.evenmentGst.Dto.ResponseCommentaire;
import com.example.evenmentGst.Entities.Commentaire;

import java.util.List;


public interface CommentaireService {


    List<ResponseCommentaire> getAllCommentaire();
    void createCommentaire(RequestCommentaire requestCommentaire);
    ResponseCommentaire getCommentaireById(Long id);
    Commentaire updateCommentaire(Long id , RequestCommentaire requestCommentaire);
    boolean deleteCommentaire(Long id);
}
