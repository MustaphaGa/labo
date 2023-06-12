package com.form.org.Controller.api;

import com.form.org.dto.ArticleDTO;
import com.form.org.dto.BiologisteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;


@Api("article")
public interface ArticleApi {

    @PostMapping(value= APP_ROOT + "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "Enregistrer un article",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un article ", response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet article cree / modifie")
    })
    ArticleDTO save(@RequestBody ArticleDTO dto);


    @GetMapping(value= APP_ROOT +"/article/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "rechercher un article par ID",notes = "Cette methode permet"
            + " de rechercher  un article par son ID ",response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe  dans la BDD avec l'ID fourni")
    })

    ArticleDTO findById(@PathVariable("idArticle") Integer idArticle);



    @GetMapping(value= APP_ROOT + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "renvoi la liste article",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des articles qui existent dans la BDD",
            responseContainer = "List<ArticleDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des articles / une liste vide"),
    })
    List<ArticleDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/article/delete/{idArticle}" )

    @ApiOperation(value = "supprimer  un article ",notes = "Cette methode permet de supprimer"
            + " un article par ID ",
            response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article a ete supprimer"),
    })
    void delecte(@PathVariable("idArticle") Integer idArticle);

}
