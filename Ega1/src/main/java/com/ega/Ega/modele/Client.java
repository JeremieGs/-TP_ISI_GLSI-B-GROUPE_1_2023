package com.ega.Ega.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotBlank;
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
    @NotNull(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  un nom valide")
    @Column(nullable = false)
    private String nom;
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  un prenom valide")
    @Column(nullable = false)
    private String prenom;
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  une date valide ")
    @Column(nullable = false)
    private LocalDate dateNaissance;
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  un sexe valide")
    @Column(length = 2,nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Column(nullable = false)
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  une adresse valide")
    private String adresse;
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  un numero de telephone valide")
    @Column(nullable = false)
    private String telephone;
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  un courriel valide")
    @Column(nullable = false,unique = true)
    private String courriel;
    @NotEmpty(message = "Ce champ est obligatoire")
    @NotBlank(message = "Entrez  une nationalite valide")
    @Column(nullable = false)
    private String nationalite;

    private  Boolean is_deleted=false;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("client")
    private List<Compte> comptes;

}
