package com.ega.Ega.repository;

import com.ega.Ega.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Clientrepository extends JpaRepository<Client,Long> {
    Client findByCourriel(String courriel);
    @Query("SELECT c FROM Client c WHERE c.is_deleted = true")
    List<Client> findAllDeletedClients();
    @Query("SELECT c FROM Client c WHERE c.is_deleted = false")
    List<Client> findAllActifClients();

}
