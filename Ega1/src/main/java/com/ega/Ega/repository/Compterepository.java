package com.ega.Ega.repository;

import com.ega.Ega.modele.Client;
import com.ega.Ega.modele.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public interface Compterepository extends JpaRepository<Compte,String> {
    Compte findByNumeroCompte(String numerocompte);
    void deleteByNumeroCompte(String numerocompte);

    @Query("SELECT c FROM Compte c WHERE c.is_deleted = true")
    List<Compte> findAllDeletedComptes();
    @Query("SELECT c FROM Compte c WHERE c.is_deleted = false")
    List<Compte> findAllActifComptes();

}
