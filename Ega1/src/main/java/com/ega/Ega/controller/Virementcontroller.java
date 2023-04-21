package com.ega.Ega.controller;

import com.ega.Ega.modele.Operation;
import com.ega.Ega.modele.Virement;
import com.ega.Ega.repository.Compterepository;
import com.ega.Ega.repository.Operationrepository;
import com.ega.Ega.repository.Virementrepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/virement")
@AllArgsConstructor
public class Virementcontroller {
    public final Virementrepository virementrepository;
    public final Compterepository compterepository;
    @GetMapping("/lister")
    public List<Virement> liste(){
        List<Virement> virement= virementrepository.findAll();
        return virement;
    }
    @GetMapping("/rechercher/{numero}")
    public List<Virement> recherche(@PathVariable String numero){
        List<Virement> virement = virementrepository.findAllByPrincipal(numero);
        if (virement.isEmpty()) {
            throw  new RuntimeException("ce compte n'existe pas ou n'es associe a aucun virement");
        }else {
            return virement;
        }
    }
}
