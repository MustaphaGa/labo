package com.form.org.Services;

import com.form.org.dto.ArticleDTO;
import com.form.org.dto.BiologisteDTO;

import java.util.List;

public interface ArticleService {

    ArticleDTO save(ArticleDTO dto);

    ArticleDTO findById(Integer idArticle);


    List<ArticleDTO> findAll();

    void delete(Integer idArticle);

}
