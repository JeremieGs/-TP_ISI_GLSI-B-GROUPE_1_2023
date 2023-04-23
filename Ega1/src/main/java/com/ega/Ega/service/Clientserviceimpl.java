package com.ega.Ega.service;

import com.ega.Ega.modele.Client;
import com.ega.Ega.repository.Clientrepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class Clientserviceimpl implements Clientservice {
    private final Clientrepository clientrepository;
    @Override
    @Transactional
    public Client creer(Client client) throws Exception {
            if(clientrepository.findByCourriel(client.getCourriel()) != null){
                throw new Exception( "email deja present dans la base de donnes");
            }
            else {
                return clientrepository.save(client);

            }
    }

    @Override
    public List Lister() {
        return clientrepository.findAll();
    }
    public List Listemasquer(){
        return clientrepository.findAllDeletedClients();
    }
    public List Listactif(){
        return clientrepository.findAllActifClients();
    }

    @Override
    public Client modifier(Long id, Client client) {
        return clientrepository.findById(id).map(p->{
            p.setNom(client.getNom());
            p.setPrenom(client.getPrenom());
            p.setAdresse(client.getAdresse());
            p.setTelephone(client.getTelephone());
            p.setCourriel(client.getCourriel());
            p.setDateNaissance(client.getDateNaissance());
            p.setNationalite(client.getNationalite());
            return clientrepository.save(p);
        }).orElseThrow(()->new RuntimeException("utilisateur non trouvé"));
    }

    @Override
    public Client masquer(Long id) {
        return clientrepository.findById(id).map(p->{
            p.setIs_deleted(true);
            return clientrepository.save(p);
        }).orElseThrow(()->new RuntimeException("utilisateur non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        clientrepository.deleteById(id);
        return "client supprimé";
    }

    @Override
    public Client info(Long id) {
        Client client = clientrepository.findById(id).orElseThrow(() -> new RuntimeException("client non trouvé"));
        return client;
    }
}
