package com.form.org.Controller.api;

import com.form.org.dto.PatientDTO;
import com.form.org.dto.RecrutementDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/recrutement")
public interface RecrutementApi {

    @PostMapping(value= APP_ROOT + "/recrutement/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un recrutement",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un recrutement ", response = RecrutementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet recrutement cree / modifie")
    })
    RecrutementDTO save(@RequestBody RecrutementDTO dto);

    @GetMapping(value= APP_ROOT + "/recrutement/{idRecrutement}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un recrutement par ID",notes = "Cette methode permet"
            + " de rechercher  un recrutement par son ID ",response = RecrutementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la recrutement a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun recrutement n'existe  dans la BDD avec l'ID fourni")
    })
    RecrutementDTO findByIdRecrutement(@PathVariable("idRecrutement") Integer idRecrutement);

    @GetMapping(value= APP_ROOT + "/recrutement/filter{dateRecrutement}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un recrutement par CODE",notes = "Cette methode"
            + " permet de rechercher un recrutement par son date ",
            response = RecrutementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la recrutement a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun recrutement n'existe  dans la BDD avec le CODE fourni")
    })
    RecrutementDTO findByDateRecrutement(@PathVariable("dateRecrutement") Date dateRecrutement);


    @ApiOperation(value = "renvoi la liste de recrutement",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des recrutements qui existent dans la BDD",
            responseContainer = "List<RecrutementDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des recrutement / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/recrutement/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<RecrutementDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/recrutement/delete/{idRecrutement}" )
    @ApiOperation(value = "supprimer  un recrutement ",notes = "Cette methode permet de supprimer"
            + " un recrutement par ID ",
            response = RecrutementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "recrutement a ete supprimer"),
    })
    void delecte(@PathVariable("idRecrutement") Integer idRecrutement);

}
