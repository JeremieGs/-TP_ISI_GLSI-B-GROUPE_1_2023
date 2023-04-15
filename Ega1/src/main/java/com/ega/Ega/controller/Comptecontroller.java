package com.ega.Ega.controller;

import com.ega.Ega.modele.Client;
import com.ega.Ega.modele.Compte;
import com.ega.Ega.modele.Virement;
import com.ega.Ega.service.Compteservice;
import com.ega.Ega.service.Compteserviceimpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Dictionary;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/compte")
@AllArgsConstructor
public class Comptecontroller {
    private final Compteservice compteservice;
    private final Compteserviceimpl compteserviceimpl;
    @PostMapping("/ajouter")
    public Compte create(@RequestBody Compte compte){
        String numeroCompte = UUID.randomUUID().toString().substring(0, 5).toUpperCase() + LocalDate.now().getYear();
        compte.setNumeroCompte(numeroCompte);
        return compteservice.creer(compte);
    }
    @GetMapping("/lister")
    public List<Compte> liste() {
        return compteservice.Lister();
    }
    @PutMapping("/versement")
    public String versement(@RequestBody Compte compte) {
        String numero=compte.getNumeroCompte();
        double montant=compte.getSolde();
        return compteservice.versement(numero,montant);
    }
    @PutMapping("/retrait")
    public String retrait(@RequestBody Compte compte) {
        String numero=compte.getNumeroCompte();
        double montant=compte.getSolde();
        return compteservice.retrait(numero,montant);
    }
    @PutMapping("/virement")
    public String virement(@RequestBody Virement virement) {
        String principal= virement.getPrincipal();
        String secondaire= virement.getSecondaire();
        double montant=virement.getMontant();
        return compteservice.virement(principal,secondaire,montant);
    }
    @PutMapping("/update/{numero}")
    public Compte modifierCompte(@PathVariable String numero, @RequestBody Compte compte) {
        return compteservice.modifier(numero, compte);
    }
    @PutMapping("/masquer/{numero}")
    public Compte masquerCompte(@PathVariable String numero) {
        return compteservice.masquer(numero);
    }
    @DeleteMapping("/supprimer/{numero}")
    public String supprimer(@PathVariable String numero){
        return compteservice.supprimer(numero);
    }

    @GetMapping("/infocompte/{numero}")
    public Compte info(@PathVariable String numero)
    {
        return compteservice.info(numero);
    }

    @GetMapping("/comptemasquer")
    public List<Client> comptemasquer(){
        return  compteserviceimpl.Listemasquer();
    }

    @GetMapping("/compteactif")
    public List<Client> compteactif(){
        return compteserviceimpl.Listeactif();
    }
}
