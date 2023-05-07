package com.form.org.Controller.api;

import com.form.org.dto.GestionStockDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api("gestionstock")
public interface GestionStockApi {


    @PostMapping(value= APP_ROOT + "/gestionstock/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "Enregistrer une gestionstock",notes = "Cette methode permet d'enresitrer ou"
            + "  modifier une gestionstock ", response = GestionStockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet gestionstock cree / modifie")
    })
    GestionStockDTO save(@RequestBody GestionStockDTO dto);

    @GetMapping(value= APP_ROOT + "/gestionstock/{idGesStock}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher d'une gestionstock par ID",notes = "Cette methode permet de rechercher d'une gestionstock par son ID ",
            response = GestionStockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la gestionstock a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun gestionstock n'existe  dans la BDD avec l'ID fourni")
    })
    GestionStockDTO findById(@PathVariable("idFacture")Integer idGesStock);

    @GetMapping(value= APP_ROOT + "/gestionstock/all", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste du gestionstock",notes = "Cette methode permet de rechercher et renvoyer la listes des facture qui existent dans la BDD",
            responseContainer = "List<GestionStockDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des gestionstock / une liste vide"),
    })
    List<GestionStockDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/gestionstock/delete/{idGesStock}" )
    @ApiOperation(value = "supprimer une gestionstock ",notes = "Cette methode permet de supprimer une gestionstock par ID ",
            response = GestionStockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la gestionstock a ete supprimer"),
    })
    void delete(@PathVariable("idGesStock")Integer idGesStock);
}
