package com.example.evenmentGst.Repository;

import com.example.evenmentGst.Entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    //    @Query("""
//select t from Token t inner join Utilisateur u on t.utilisateur.id where u.id = :utilisateurId and (
//t.expired=false or t.revoked=false )""")
//    List<Token> findAllValidTokensByUser(Long utilisateurId);
    @Query("""
            select t from Token t inner join Utilisateur u on t.utilisateur.id = u.id where u.id = :utilisateurId and (
            t.expired=false or t.revoked=false )""")
    List<Token> findAllValidTokensByUser(Long utilisateurId);

    Optional<Token> findByToken(String token
    );
}
