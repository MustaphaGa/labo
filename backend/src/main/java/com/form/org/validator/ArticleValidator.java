package com.form.org.validator;

import com.form.org.dto.ArticleDTO;
import com.form.org.dto.BiologisteDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDTO articleDTO){
        List<String> errors = new ArrayList<String>();

        if(articleDTO == null) {
            errors.add("veuillez renseigner le nom d'article!!");
            errors.add("veuillez renseigner le prix d'article!!");
            errors.add("veuillez renseigner le type d'article!!");
            errors.add("veuillez renseigner le code barre  d'article!!");



            return errors;
        }

        if(!StringUtils.hasLength(articleDTO.getNomArticle())) {
            errors.add("veuillez renseigner le nom d'article!!");
        }
        if(!StringUtils.hasLength(articleDTO.getPrixArticle())) {
            errors.add("veuillez renseigner le prix d'article!!");
        }
        if(!StringUtils.hasLength(articleDTO.getTypeArticle())) {
            errors.add("veuillez renseigner le prix d'article!!");
        }
        if(!StringUtils.hasLength(articleDTO.getCodeBarre())) {
            errors.add("veuillez renseigner le prix d'article!!");
        }



        return errors;
    }
}
