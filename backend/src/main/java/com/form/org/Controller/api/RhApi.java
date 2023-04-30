package com.form.org.Controller.api;

import com.form.org.dto.RhDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/rh")
public interface RhApi {


    @PostMapping(value= APP_ROOT + "/rh/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un rh",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un rh ", response = RhDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet patient cree / modifie")
    })
    RhDTO save(@RequestBody RhDTO dto);

    @GetMapping(value= APP_ROOT + "/rh/{idRh}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un rh par ID",notes = "Cette methode permet"
            + " de rechercher  un rh par son ID ",response = RhDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " rh a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun rh n'existe  dans la BDD avec l'ID fourni")
    })
    RhDTO findById(@PathVariable("idRh") Integer idRh);


    @ApiOperation(value = "renvoi la liste de rh",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des rh qui existent dans la BDD",
            responseContainer = "List<RhDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des rh / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/rh/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<RhDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/rh/delete/{idRh}" )
    @ApiOperation(value = "supprimer  un rh ",notes = "Cette methode permet de supprimer"
            + " un rh par ID ",
            response = RhDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "rh a ete supprimer"),
    })
    void delecte(@PathVariable("idRh") Integer idRh);

}
