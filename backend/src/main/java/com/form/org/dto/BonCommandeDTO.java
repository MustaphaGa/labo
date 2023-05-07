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


        private GestionStockDTO gestionStock;


        private FournisseurDTO fournisseur;


        private FactureDTO facture;



        public static com.form.org.dto.BonCommandeDTO fromEntity(BonCommande bonCommande) {
            if(bonCommande == null) {
                return null;
            }
            return   com.form.org.dto.BonCommandeDTO.builder()
                    .idBonCommande(bonCommande.getIdBonCommande())
                    .dateCommande(bonCommande.getDateCommande())
                    .prix(bonCommande.getPrix())
                    .gestionStock(GestionStockDTO.fromEntity(bonCommande.getGestionStock()))
                    .fournisseur(FournisseurDTO.fromEntity(bonCommande.getFournisseur()))
                    .facture(FactureDTO.fromEntity(bonCommande.getFacture()))
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
            bonCommande.setGestionStock(GestionStockDTO.toEntity(bonCommandeDTO.getGestionStock()));
            bonCommande.setFournisseur(FournisseurDTO.toEntity(bonCommandeDTO.getFournisseur()));

            return bonCommande;
        }

    }

