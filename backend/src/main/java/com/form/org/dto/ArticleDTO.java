package com.form.org.dto;

import com.form.org.model.Article;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class ArticleDTO{


    private Integer idArticle;
    private String NomArticle;
    private String prixArticle;
    private String typeArticle;
    private String codeBarre;


    public static ArticleDTO fromEntity(Article article) {
        if(article == null) {
            return null;
        }
        return
                ArticleDTO.builder()
                        .idArticle(article.getIdArticle())
                        .NomArticle(article.getNomArticle())
                        .prixArticle(article.getPrixArticle())
                        .typeArticle(article.getTypeArticle())
                        .codeBarre(article.getCodeBarre())
                       // .bonCommande(BonCommandeDTO.fromEntity(article.getBonCommande()))
                       // .stock(StockDTO.fromEntity(article.getStock()))
                        .build();
    }


    public static Article toEntity(ArticleDTO articleDTO) {
        if(articleDTO == null  ) {
            return null ;
        }
        Article article = new Article();

        article.setIdArticle(articleDTO.getIdArticle());
        article.setNomArticle(articleDTO.getNomArticle());
        article.setPrixArticle(articleDTO.getPrixArticle());
        article.setTypeArticle(articleDTO.getTypeArticle());
        article.setCodeBarre(articleDTO.getCodeBarre());
       // article.setBonCommande(BonCommandeDTO.toEntity(articleDTO.getBonCommande()));
       // article.setStock(StockDTO.toEntity(articleDTO.getStock()));
        return article;
    }

}
