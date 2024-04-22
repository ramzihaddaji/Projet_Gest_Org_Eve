package com.example.evenmentGst.Dto;


import com.example.evenmentGst.Entities.Choice;
import com.example.evenmentGst.Entities.Evenement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseChoice {

     Long id;
     String label;
     String value;
     Instant createdAt;
     Instant updatedAt;
    Long questionId ;
    private ResponseQuestion question;
    public static ResponseChoice makeChoice(Choice choice){
        return ResponseChoice.builder()
                .id(choice.getId())
                .label(choice.getLabel())
                .value(choice.getValue())

                .createdAt(choice.getCreatedAt())
                .updatedAt(choice.getUpdatedAt())
                .build();
    }
}
