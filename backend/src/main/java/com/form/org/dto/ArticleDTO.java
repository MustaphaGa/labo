package com.form.org.dto;

import com.form.org.model.Article;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDTO{


    private Integer idArticle;
    private String articleName;
    private String quantite;
    private BonCommandeDTO bonCommande;
    private StockDTO stock;


    public static ArticleDTO fromEntity(Article article) {
        if(article == null) {
            return null;
        }
        return
                ArticleDTO.builder()
                        .idArticle(article.getIdArticle())
                        .articleName(article.getArticleName())
                        .quantite(article.getQuantite())
                        .bonCommande(BonCommandeDTO.fromEntity(article.getBonCommande()))
                        .stock(StockDTO.fromEntity(article.getStock()))
                        .build();
    }


    public static Article toEntity(ArticleDTO articleDTO) {
        if(articleDTO == null  ) {
            return null ;
        }
        Article article = new Article();

        article.setIdArticle(articleDTO.getIdArticle());
        article.setArticleName(articleDTO.getArticleName());
        article.setQuantite(articleDTO.getQuantite());
        article.setBonCommande(BonCommandeDTO.toEntity(articleDTO.getBonCommande()));
        article.setStock(StockDTO.toEntity(articleDTO.getStock()));
        return article;
    }

}
