package com.form.org.Controller.api;

import com.form.org.dto.OperationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/operation")
public interface OperationApi {


    @PostMapping(value= APP_ROOT + "/operation/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un operation",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un operation ", response = OperationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet operation cree / modifie")
    })
    OperationDTO save(@RequestBody OperationDTO dto);

    @GetMapping(value= APP_ROOT + "/operation/{idOperation}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un operation par ID",notes = "Cette methode permet"
            + " de rechercher  un operation par son ID ",response = OperationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la operation a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun operation n'existe  dans la BDD avec l'ID fourni")
    })
    OperationDTO findById(@PathVariable("idOperation") Integer idOperation);

    @GetMapping(value= APP_ROOT + "/operation/filter{dateOperation}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un operation par date",notes = "Cette methode"
            + " permet de rechercher un operation par son date ",
            response = OperationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la operation a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun operation n'existe  dans la BDD avec le date fourni")
    })
    OperationDTO findByDateOperation(@PathVariable("dateOperation") Date dateOperation);

    @ApiOperation(value = "renvoi la liste de operation",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des operations qui existent dans la BDD",
            responseContainer = "List<OperationDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des opertions / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/operation/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<OperationDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/operation/delete/{idOperation}" )
    @ApiOperation(value = "supprimer  un operation ",notes = "Cette methode permet de supprimer"
            + " un operation par ID ",
            response = OperationDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "operation a ete supprimer"),
    })
    void delecte(@PathVariable("idOperation") Integer idOperation);
}
