package com.ega.Ega.repository;

import com.ega.Ega.modele.Compte;
import com.ega.Ega.modele.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Operationrepository extends JpaRepository<Operation,String > {

    @Query("SELECT o FROM Operation o WHERE o.compte = :compte")
    List<Operation> findAllByCompte(@Param("compte") String compte);
}
