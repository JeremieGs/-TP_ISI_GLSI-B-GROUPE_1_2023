package com.ega.Ega.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compte;
    @Enumerated(EnumType.STRING)
    private Typeoperation typeoperation;
    private double montant;
    private LocalDate  date;
}
