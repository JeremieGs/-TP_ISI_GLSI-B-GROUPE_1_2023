package com.ega.Ega.service;

import com.ega.Ega.modele.Client;
import com.ega.Ega.modele.Compte;
import com.ega.Ega.repository.Clientrepository;
import com.ega.Ega.repository.Compterepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
@AllArgsConstructor
public class Compteserviceimpl implements Compteservice{
    private final Compterepository compterepository;
    private final Clientrepository clientrepository;
    @Override
    public Compte creer(Compte compte) {
        return compterepository.save(compte);
    }

    @Override
    public List Lister() {
        return compterepository.findAll();
    }
    public List Listemasquer() {
        return compterepository.findAllDeletedComptes();
    }
    public List Listeactif() {
        return compterepository.findAllActifComptes();
    }

    @Override
    public Compte modifier(String numero, Compte compte) {
        Compte compte1 = compterepository.findByNumeroCompte(numero);
        if (compte1 == null) {
            throw  new RuntimeException("compte introuvable");

        }
        compte1.setTypeCompte(compte.getTypeCompte());
        return compterepository.save(compte1);
    }

    @Override
    public String Listecompteclient(Long id) {
        // Récupérer le client à partir de son ID
        Client client = clientrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return "";
    }

    @Override
    public String versement(String numero, double montant) {

        Compte compte = compterepository.findByNumeroCompte(numero);
        if(compte == null){
        return ( "compte introuvable "+numero);
        }
        if(montant < 0){
            return "montant de versement negatif";
        }else {
            compte.setSolde(compte.getSolde()+montant);
            compterepository.save(compte);
            return "le nouveau solde du compte "+numero+" est de  "+compte.getSolde().toString()+"("+montant+") viens d'etre ajouter";
        }
    }

    @Override
    public String retrait(String numero, double montant) {
        Compte compte = compterepository.findByNumeroCompte(numero);
        if(compte == null){
            return "compte introuvable";
        }
        if(montant <0 ){
            return "montant de retrait negatif";
        }
        else {
            if (compte.getSolde() < montant) {
                return ("Solde("+compte.getSolde()+") insuffisant pour retrait de "+montant);
            }
            compte.setSolde(compte.getSolde()-montant);
            compterepository.save(compte);
            return "le nouveau solde est de  "+compte.getSolde().toString()+"("+montant+") viens d'etre retirer";

        }

    }

    @Override
    public String virement(String numeroprincipal, String numerosecondaire, double montant) {
        Compte comptePrincipal = compterepository.findByNumeroCompte(numeroprincipal);
        if(comptePrincipal == null){
            return ("compte principale ("+numeroprincipal+")(->) introuvable");
        }

        Compte compteSecondaire = compterepository.findByNumeroCompte(numerosecondaire);
        if(compteSecondaire == null){
            return ("compte secondaire ("+numerosecondaire+")<- introuvable");
        }
        if(montant<0){
            return ( "MONTANT DE VIREMENT NE PEUT PAS ETRE NEGATIF");
        }
        if (comptePrincipal.getSolde() < montant) {
            return ("Solde insuffisant ("+comptePrincipal.getSolde()+")");
        }
        double nouveauSoldePrincipal = comptePrincipal.getSolde() - montant;
        double nouveauSoldeSecondaire = compteSecondaire.getSolde() + montant;
        comptePrincipal.setSolde(nouveauSoldePrincipal);
        compteSecondaire.setSolde(nouveauSoldeSecondaire);
        compterepository.save(comptePrincipal);
        compterepository.save(compteSecondaire);
        double newsolde=comptePrincipal.getSolde()-montant;
        return "votre nouveau solde est de "+newsolde;
    }

    @Override
    public Compte masquer(String numero) {
        Compte compte= compterepository.findByNumeroCompte(numero);
        if(compte == null){
           throw new RuntimeException( "compte introuvable");
        }
        compte.setIs_deleted(true);
        return compterepository.save(compte);
        }

    @Override
    public String supprimer(String numero) {
        compterepository.deleteByNumeroCompte(numero);
        return "compte "+numero+" supprimé";
    }

    @Override
    public Compte info(String numero) {
        Compte compte = compterepository.findByNumeroCompte(numero);
        if(compte == null){
            throw new RuntimeException("compte introuvable");
        }
        return compte;
    }


}
