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
        private Integer QuantiteCommande;

        private FournisseurDTO fournisseur;
        private ArticleDTO article;






        public static BonCommandeDTO fromEntity(BonCommande bonCommande) {
            if(bonCommande == null) {
                return null;
            }
            return   BonCommandeDTO.builder()
                    .idBonCommande(bonCommande.getIdBonCommande())
                    .dateCommande(bonCommande.getDateCommande())
                    .QuantiteCommande(bonCommande.getQuantiteCommande())

                    .fournisseur(FournisseurDTO.fromEntity(bonCommande.getFournisseur()))
                    .article(ArticleDTO.fromEntity(bonCommande.getArticle()))


                    .build();
        }


        public static BonCommande toEntity(com.form.org.dto.BonCommandeDTO bonCommandeDTO) {

            if(bonCommandeDTO== null) {
                return null;

            }
            BonCommande bonCommande= new BonCommande();
            bonCommande.setIdBonCommande(bonCommandeDTO.getIdBonCommande());
            bonCommande.setDateCommande(bonCommandeDTO.getDateCommande());
            bonCommande.setQuantiteCommande(bonCommandeDTO.getQuantiteCommande());

            bonCommande.setArticle(ArticleDTO.toEntity(bonCommandeDTO.getArticle()));
            bonCommande.setFournisseur(FournisseurDTO.toEntity(bonCommandeDTO.getFournisseur()));


            return bonCommande;
        }

    }

