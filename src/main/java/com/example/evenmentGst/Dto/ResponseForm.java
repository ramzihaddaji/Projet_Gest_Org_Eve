package com.example.evenmentGst.Dto;
import com.example.evenmentGst.Entities.Evenement;
import com.example.evenmentGst.Entities.Form;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseForm {

     Long id;
     String type ;
     String label ;
     String name;
     String value ;
     String options ;
     Boolean required ;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;

    public static ResponseForm makeForm(Form form){
        return ResponseForm.builder()
                .id(form.getId())
//                .type(form.getType())
//                .label(form.getLabel())
//                .name(form.getName())
//                .value(form.getValue())
//                .options(form.getOptions())
//                .required(form.getRequired())
                .createdAt(form.getCreatedAt())
                .updatedAt(form.getUpdatedAt())
                .build();
    }

}
