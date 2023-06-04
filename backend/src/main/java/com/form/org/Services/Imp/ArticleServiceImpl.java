package com.form.org.Services.Imp;

import com.form.org.Repository.ArticleRepositoyry;
import com.form.org.Services.ArticleService;
import com.form.org.dto.ArticleDTO;
import com.form.org.dto.BiologisteDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Article;
import com.form.org.model.Biologiste;
import com.form.org.validator.ArticleValidator;
import com.form.org.validator.BiologisteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {


    private ArticleRepositoyry articleRepositoyry;
    @Autowired
    public ArticleServiceImpl(ArticleRepositoyry articleRepositoyry) {
        this.articleRepositoyry = articleRepositoyry;
    }

    @Override
    public ArticleDTO save(ArticleDTO dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("article n'est pas valide {}", dto);
            throw new InvalidEntityException("article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDTO.fromEntity(articleRepositoyry.save(ArticleDTO.toEntity(dto)));
    }


    @Override
    public ArticleDTO findById(Integer idArticle) {
        if (idArticle == null) {
            log.error("article id is null");
            return null;
        }
        Optional<Article> article = articleRepositoyry.findById(idArticle);

            return Optional.of(ArticleDTO.fromEntity(article.get()))
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun article avec l'ID =" + idArticle + "n'été trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleRepositoyry.findAll()
                .stream().map(ArticleDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idArticle) {
        if (idArticle == null) {
            log.error("article id is null");
            return;
        }
        articleRepositoyry.deleteById(idArticle);

    }
}
