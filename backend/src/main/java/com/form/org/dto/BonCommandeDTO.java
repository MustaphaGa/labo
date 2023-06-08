package com.form.org.dto;

import com.form.org.model.BonCommande;
import lombok.Builder;
import lombok.Data;

import java.util.Date;




    @Builder
    @Data
    public class BonCommandeDTO {
        private Integer idBonCommande;
        private Date dateCommande;
        private double prix;





        private FournisseurDTO fournisseur;


        private FactureDTO facture;
        private EmployeDTO employe;



        public static BonCommandeDTO fromEntity(BonCommande bonCommande) {
            if(bonCommande == null) {
                return null;
            }
            return   com.form.org.dto.BonCommandeDTO.builder()
                    .idBonCommande(bonCommande.getIdBonCommande())
                    .dateCommande(bonCommande.getDateCommande())
                    .prix(bonCommande.getPrix())
                    .fournisseur(FournisseurDTO.fromEntity(bonCommande.getFournisseur()))
                    .facture(FactureDTO.fromEntity(bonCommande.getFacture()))
                    //.employe(EmployeDTO.fromEntity(bonCommande.getEmploye()))
                    .build();
        }


        public static BonCommande toEntity(com.form.org.dto.BonCommandeDTO bonCommandeDTO) {

            if(bonCommandeDTO== null) {
                return null;

            }
            BonCommande bonCommande= new BonCommande();

            bonCommande.setIdBonCommande(bonCommandeDTO.getIdBonCommande());
            bonCommande.setDateCommande(bonCommandeDTO.getDateCommande());
            bonCommande.setPrix(bonCommandeDTO.getPrix());
            bonCommande.setFacture(FactureDTO.toEntity(bonCommandeDTO.getFacture()));
            bonCommande.setFournisseur(FournisseurDTO.toEntity(bonCommandeDTO.getFournisseur()));
          //  bonCommande.setEmploye(EmployeDTO.toEntity(bonCommandeDTO.getEmploye()));

            return bonCommande;
        }

    }

