package com.ega.Ega.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.UUID;

enum TypeCompte{
    EPARGNE,
    COURANT
}

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Compte")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroCompte;

    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

    private LocalDate dateCreation=LocalDate.now();

    private Double solde=0.0;

    private  Boolean is_deleted=false;
    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnoreProperties("comptes")
    private Client client;

}
