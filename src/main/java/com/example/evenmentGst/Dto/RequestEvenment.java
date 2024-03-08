package com.example.evenmentGst.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvenment {
    Long idEven;
    String nom;
    DateTimeLiteralExpression.DateTime date_debut;
    DateTimeLiteralExpression.DateTime date_fin;

}
