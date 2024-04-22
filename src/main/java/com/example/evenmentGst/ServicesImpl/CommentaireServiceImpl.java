package com.example.evenmentGst.ServicesImpl;

import com.example.evenmentGst.Dto.RequestCommentaire;

import com.example.evenmentGst.Dto.ResponseCommentaire;

import com.example.evenmentGst.Entities.Categorie;
import com.example.evenmentGst.Entities.Commentaire;

import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Repository.CommentaireRepository;
import com.example.evenmentGst.Repository.EvenementRepository;
import com.example.evenmentGst.Service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private EvenementRepository evenementRepository;
    @Override
    public List<ResponseCommentaire> getAllCommentaire() {
        List<Commentaire> commentaires =commentaireRepository.findAll();
        List<ResponseCommentaire> commentairesFormated = new ArrayList<>();
        for (Commentaire commentaire : commentaires){
            ResponseCommentaire categorieF=ResponseCommentaire.makeCommentaire(commentaire);
            commentairesFormated.add(categorieF);
        }

        return commentairesFormated;
    }

    @Override
    public void createCommentaire(RequestCommentaire requestCommentaire) {
        Evenement evenement = evenementRepository.findById(requestCommentaire.getEvenementId()).orElseThrow();
        Commentaire commentaire = Commentaire.builder()
                .commentaire(requestCommentaire.getCommentaire())
                .note(requestCommentaire.getNote())
                .evenement(evenement)
                .build();
        commentaireRepository.save(commentaire);

    }

    @Override
    public ResponseCommentaire getCommentaireById(Long id) {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        return ResponseCommentaire.makeCommentaire(commentaire.get());
    }

    @Override
    public Commentaire updateCommentaire(Long id, RequestCommentaire requestCommentaire) {
        Commentaire commentaire = commentaireRepository.findById(id).orElseThrow();
        if (requestCommentaire.getCommentaire() != null) {
            commentaire.setCommentaire(requestCommentaire.getCommentaire());
        }
        if (requestCommentaire.getNote() != null) {
            commentaire.setNote(requestCommentaire.getNote());
        }
        return commentaireRepository.save(commentaire);
    }

    @Override
    public boolean deleteCommentaire(Long id) {
        if (!commentaireRepository.existsById(id)){
            return false ;
        }
        commentaireRepository.deleteById(id);
        return true;
    }
}
