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
            errors.add("veuillez renseigner le nom de article!!");
            errors.add("veuillez renseigner quantite article !!");
            errors.add("veuillez renseigner le stock !!");
            errors.add("veuillez renseigner le boncommand !!");

            return errors;
        }

        if(!StringUtils.hasLength(articleDTO.getArticleName())) {
            errors.add("veuillez renseigner le nom de biologiste!!");
        }
        if(!StringUtils.hasLength(articleDTO.getQuantite())) {
            errors.add("veuillez renseigner le prénom de biologiste !!");
        }

        if(articleDTO.getBonCommande()==null) {
            errors.add("veuillez renseigner le boncommande !!");
        }


        if(articleDTO.getStock()==null) {
            errors.add("veuillez renseigner le stock !!");
        }

        return errors;
    }
}
