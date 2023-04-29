package com.form.org.Controller.api;

import com.form.org.dto.CongeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/conge")
public interface CongeApi {


    @PostMapping(value= APP_ROOT + "/conge/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un conge",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un conge ", response = CongeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet conge cree / modifie")
    })
    CongeDTO save(@RequestBody CongeDTO dto);

    @GetMapping(value= APP_ROOT + "/conge/{idConge}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un conge par ID",notes = "Cette methode permet"
            + " de rechercher  un conge par son ID ",response = CongeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "conge a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun conge n'existe  dans la BDD avec l'ID fourni")
    })
    CongeDTO findById(@PathVariable("idConge") Integer idConge);



    @ApiOperation(value = "renvoi la liste de conge",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des conges qui existent dans la BDD",
            responseContainer = "List<CongeDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des patients / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/conge/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<CongeDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/conge/delete/{idConge}" )
    @ApiOperation(value = "supprimer  un conge ",notes = "Cette methode permet de supprimer"
            + " un conge par ID ",
            response = CongeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "patient a ete supprimer"),
    })
    void delecte(@PathVariable("idConge") Integer idConge);

}
