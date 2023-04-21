package com.ega.Ega.repository;

import com.ega.Ega.modele.Operation;
import com.ega.Ega.modele.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Virementrepository extends JpaRepository<Virement,String> {
    @Query("SELECT v FROM Virement v WHERE v.principal = :principal or v.secondaire =:principal" )
    List<Virement> findAllByPrincipal(@Param("principal") String principal);

}
