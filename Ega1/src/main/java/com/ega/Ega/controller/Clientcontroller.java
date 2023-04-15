package com.ega.Ega.controller;

import com.ega.Ega.modele.Client;
import com.ega.Ega.repository.Clientrepository;
import com.ega.Ega.service.Clientservice;
import com.ega.Ega.service.Clientserviceimpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class Clientcontroller {
    private final Clientservice clientservice;
    private final Clientserviceimpl clientserviceimpl;
    @PostMapping("/ajouter")
    public Client create(@RequestBody Client client) throws Exception {
        return clientservice.creer(client);
    }
    @GetMapping("/lister")
    public List<Client> liste() {
        return clientservice.Lister();
    }
    @PutMapping("/update/{id}")
    public Client modifierClient(@PathVariable Long id, @RequestBody Client client) {
     return clientservice.modifier(id,client);
    }

    @PutMapping("/masquer/{id}")
    public Client masquerClient(@PathVariable Long id) {
        return clientservice.masquer(id);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return clientservice.supprimer(id);
    }

    @GetMapping("/infoclient/{id}")
    public Client info(@PathVariable Long id){
        return clientservice.info(id);
    }

    @GetMapping("/clientmasquer")
    public List<Client> clientmasquer(){
        return  clientserviceimpl.Listemasquer();
    }

    @GetMapping("/clientactif")
    public List<Client> clientactif(){
        return clientserviceimpl.Listactif();
    }

}
