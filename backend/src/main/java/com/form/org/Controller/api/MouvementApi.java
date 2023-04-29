package com.form.org.Controller.api;

import com.form.org.dto.MouvementDTO;
import com.form.org.dto.PatientDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;
@Api(APP_ROOT +"/mouvement")
public interface MouvementApi {

    @PostMapping(value= APP_ROOT + "/mouvement/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un mouvement",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un mouvement ", response = MouvementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet mouvement cree / modifie")
    })
    MouvementDTO save(@RequestBody MouvementDTO dto);

    @GetMapping(value= APP_ROOT + "/mouvement/{idMouvement}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un mouvement par ID",notes = "Cette methode permet"
            + " de rechercher  un mouvement par son ID ",response = MouvementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la patient a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun patient n'existe  dans la BDD avec l'ID fourni")
    })
    MouvementDTO findById(@PathVariable("idMouvement") Integer idMouvement);

    @GetMapping(value= APP_ROOT + "/patient/filter{typeMouvement}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un mouvement par CODE",notes = "Cette methode"
            + " permet de rechercher un mouvement par son CODE ",
            response = MouvementDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la mouvement a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun mouvement n'existe  dans la BDD avec le CODE fourni")
    })
    MouvementDTO findPatientByCodePatient(@PathVariable("typeMouvement") String typeMouvement);

    @ApiOperation(value = "renvoi la liste de mouvement",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des mouvements qui existent dans la BDD",
            responseContainer = "List<MouvementDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des mouvements / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/mouvement/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<MouvementDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/patient/delete/{idMouvement}" )
    @ApiOperation(value = "supprimer  un mouvement ",notes = "Cette methode permet de supprimer"
            + " un mouvement par ID ",
            response = PatientDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "patient a ete supprimer"),
    })
    void delecte(@PathVariable("idMouvement") Integer idMouvement);
}
