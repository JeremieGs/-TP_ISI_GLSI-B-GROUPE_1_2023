package com.ega.Ega.service;

import com.ega.Ega.modele.Client;

import java.util.List;


public interface Clientservice {
    Client creer(Client client) throws Exception;
    List<Client> Lister();
    Client modifier(Long id,Client client);
    Client masquer(Long id);
    String supprimer(Long id);
    Client info(Long id);
}
