package com.form.org.Controller;

import com.form.org.Controller.api.ArticleApi;
import com.form.org.Services.ArticleService;
import com.form.org.dto.ArticleDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDTO save(ArticleDTO dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDTO findById(Integer idArticle) {
        return articleService.findById(idArticle);
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delecte(Integer idArticle) {
        articleService.delete(idArticle);

    }
}
