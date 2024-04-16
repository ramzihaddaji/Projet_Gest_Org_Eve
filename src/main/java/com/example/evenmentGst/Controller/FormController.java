package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Entities.Form;
import com.example.evenmentGst.Entities.Question;
import com.example.evenmentGst.Repository.FormRepository;
import com.example.evenmentGst.ServicesImpl.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/auth/evenements/submit-form")
public class FormController {

    @Autowired
    private FormRepository formDataRepository; // Supposons que vous avez un repository pour les données du formulaire

    @PostMapping("/api/submit-form")
    public ResponseEntity<String> submitForm(@RequestBody Form formData) {
        try {
            // Enregistrez les données du formulaire dans la base de données
            formDataRepository.save(formData);
            return ResponseEntity.ok("Formulaire soumis avec succès");
        } catch (Exception e) {
            // Gérez les erreurs d'enregistrement dans la base de données
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la soumission du formulaire");
        }
    }
}
