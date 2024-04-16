package com.example.evenmentGst.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestForm {
     String type ;
     String label ;
     String name;
     String value ;
     String options ;
     Boolean required ;

}
