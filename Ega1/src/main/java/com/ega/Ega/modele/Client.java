package com.ega.Ega.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

enum Sexe {
    M,
    F
}

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "le champ nom est obligatoire")
    @NotBlank(message = "entrez  un nom valide")
    @Column(nullable = false)
    private String nom;
    @NotEmpty(message = "le champ prenom est obligatoire")
    @NotBlank(message = "entrez  un prenom valide")
    @Column(nullable = false)
    private String prenom;
    @NotEmpty(message = "le champ date de naissance est obligatoire")
    @NotBlank(message = "entrez  une date de naissance valide ")
    @Column(nullable = false)
    private LocalDate dateNaissance;
    @NotEmpty(message = "le champ sexe est obligatoire")
    @NotBlank(message = "entrez  un sexe valide")
    @Column(length = 2,nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Column(nullable = false)
    @NotEmpty(message = "le champ adresse est obligatoire")
    @NotBlank(message = "entrez  une adresse valide")
    private String adresse;
    @NotEmpty(message = "le champ telephone est obligatoire")
    @NotBlank(message = "entrez  un numero de telephone valide")
    @Column(nullable = false)
    private String telephone;
    @NotEmpty(message = "le champ courriel est obligatoire")
    @NotBlank(message = "entrez  un courriel valide")
    @Column(nullable = false,unique = true)
    private String courriel;
    @NotEmpty(message = "le champ nationalite est obligatoire")
    @NotBlank(message = "entrez  une nationalite valide")
    @Column(nullable = false)
    private String nationalite;

    private  Boolean is_deleted=false;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("client")
    private List<Compte> comptes;

}
