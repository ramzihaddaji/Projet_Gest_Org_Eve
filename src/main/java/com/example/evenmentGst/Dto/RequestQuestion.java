package com.example.evenmentGst.Dto;

import com.example.evenmentGst.Entities.InputType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestQuestion {


    String title;
    InputType inputType;
    Long categorieId;
//    List<String> choices;
List<RequestChoice> choices;




}
