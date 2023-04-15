package com.ega.Ega.service;

import com.ega.Ega.modele.Compte;

import java.util.List;

public interface Compteservice {
    Compte creer(Compte compte);
    List<Compte> Lister();
    Compte modifier(String numero,Compte compte);
    String Listecompteclient(Long id);
    String versement(String numero , double montant);
    String retrait(String numero , double montant);
    String virement(String numeroprincipal,String numerosecondaire,double montant);
    Compte masquer(String numero);
    String supprimer(String numero);
    Compte info(String numero);
}
