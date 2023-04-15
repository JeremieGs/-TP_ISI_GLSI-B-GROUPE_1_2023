package com.ega.Ega.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Virement {

    private String principal;
    private String secondaire;
    private double montant;
}
