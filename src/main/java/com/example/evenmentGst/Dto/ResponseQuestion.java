package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.Choice;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.InputType;
import com.example.evenmentGst.Entities.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseQuestion {

    Long id;
    String title;
    InputType inputType;
    Instant createdAt;
    Instant updatedAt;
//    Long categorieId;
    String categorieName;
//    private ResponseCategorie categorie;
//    List<String> choices; // Ajout de la liste des choix

    public static ResponseQuestion makeQuestion(Question question) {
        return ResponseQuestion.builder()
                .id(question.getId())
                .title(question.getTitle())
                .inputType(question.getInputType())
//                .categorie(ResponseCategorie.makeCategorie(question.getCategorie()))
                .categorieName(question.getCategorie().getNom())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
//                .choices(question.getChoices().stream().map(Choice::getLabel).collect(Collectors.toList()))
                .build();
    }
}
