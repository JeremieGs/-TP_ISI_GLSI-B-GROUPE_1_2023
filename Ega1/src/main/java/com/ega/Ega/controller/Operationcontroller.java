package com.ega.Ega.controller;

import com.ega.Ega.modele.Operation;
import com.ega.Ega.repository.Compterepository;
import com.ega.Ega.repository.Operationrepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operation")
@AllArgsConstructor
public class Operationcontroller {
    public final Operationrepository operationrepository;
    public final Compterepository compterepository;
    @GetMapping("/lister")
    public List<Operation>  liste(){
        List<Operation> operation= operationrepository.findAll();
        return operation;
    }
    @GetMapping("/rechercher/{numero}")
    public List<Operation> recherche(@PathVariable String numero){
        if (compterepository.findByNumeroCompte(numero) == null){
            throw  new RuntimeException("ce compte n'existe pas");
        }else {
            return operationrepository.findAllByCompte(numero);
        }
    }

}
