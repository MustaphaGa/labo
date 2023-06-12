package com.form.org.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FournisseurDTO {

    private Integer idFournisseur;
    private String nom;
    private String prenom;
    private  String Adresse;
    private String telephone;


    @JsonIgnore
    private List<BonCommandeDTO> bonCommandes;


    public static FournisseurDTO fromEntity(Fournisseur fournisseur) {
        if(fournisseur == null) {
            return null;
        }
        return   FournisseurDTO.builder()
                .idFournisseur(fournisseur.getIdFournisseur())
                .nom(fournisseur.getNom())
                .Adresse(fournisseur.getAdresse())
                .prenom(fournisseur.getPrenom())
                .telephone(fournisseur.getTelephone())

                .build();
    }


    public static Fournisseur toEntity(FournisseurDTO fournisseurDTO) {

        if(fournisseurDTO== null) {
            return null;

        }
        Fournisseur fournisseur= new Fournisseur();

        fournisseur.setIdFournisseur(fournisseurDTO.getIdFournisseur());
        fournisseur.setNom(fournisseurDTO.getNom());
        fournisseur.setPrenom(fournisseurDTO.getPrenom());
        fournisseur.setAdresse(fournisseurDTO.getAdresse());
        fournisseur.setTelephone(fournisseurDTO.getTelephone());


        return fournisseur;
    }
}
