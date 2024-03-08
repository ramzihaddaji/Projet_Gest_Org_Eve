package com.example.evenmentGst.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "evenement")
@Builder
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idEven ;
    String nom;
    DateTimeLiteralExpression.DateTime date_debut;
    DateTimeLiteralExpression.DateTime date_fin ;
    @CreationTimestamp
    private Instant createdAt;
    @CreationTimestamp
    private Instant updatedAt;
    @OneToMany(mappedBy = "evenement")
    private List<Categorie> categories ;
//    @OneToMany(mappedBy = "evenement");
//    private List<Categorie> categories ;

}
