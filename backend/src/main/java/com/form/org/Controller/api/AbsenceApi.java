package com.form.org.Controller.api;

import com.form.org.dto.AbsenceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/absence")
public interface AbsenceApi {

    @PostMapping(value= APP_ROOT + "/absence/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer absence",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un absence ", response = AbsenceDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet absence cree / modifie")
    })
    AbsenceDTO save(@RequestBody AbsenceDTO dto);

    @GetMapping(value= APP_ROOT + "/absence/{idAbsence}", produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "rechercher un absence par ID",notes = "Cette methode permet"
            + " de rechercher  un absence par son ID ",response = AbsenceDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "absence a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun absence n'existe  dans la BDD avec l'ID fourni")
    })
    AbsenceDTO findById(@PathVariable("idAbsence")Integer idAbsence);

    @GetMapping(value= APP_ROOT + "/absence/filter{motif}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un absence par SPECIALITE",notes = "Cette methode"
            + " permet de rechercher un absence par son SPECIALITE ",
            response = AbsenceDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "absence a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "absence biologiste n'existe  dans la BDD avec le CODE fourni")
    })
    AbsenceDTO findByMotif(@PathVariable("motif")String motif);

    @GetMapping(value= APP_ROOT + "/absence/all", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste de absence",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des absences qui existent dans la BDD",
            responseContainer = "List<AbsenceDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des absneces / une liste vide"),
    })
    List<AbsenceDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/absence/delete/{idAbsence}" )
    @ApiOperation(value = "supprimer  un absence ",notes = "Cette methode permet de supprimer"
            + " un absence par ID ",
            response = AbsenceDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "absence a ete supprimer"),
    })
    void delete(@PathVariable("idAbsence")Integer idAbsence);
}
