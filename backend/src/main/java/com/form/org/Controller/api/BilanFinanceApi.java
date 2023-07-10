package com.form.org.Controller.api;

import com.form.org.dto.BilanFinancierDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/bilanfinance")
public interface BilanFinanceApi {

    @PostMapping(value= APP_ROOT + "/bilanfinance/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un bilanfinance",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un bilanfinance ", response = BilanFinancierDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet idBilan cree / modifie")
    })
    BilanFinancierDTO save(@RequestBody BilanFinancierDTO dto);

    @GetMapping(value= APP_ROOT + "/bilanfinance/{idBilan}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un bilanfinance par ID",notes = "Cette methode permet"
            + " de rechercher  un bilanfinance par son ID ",response = BilanFinancierDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " bilanfinance a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun bilanfinance n'existe  dans la BDD avec l'ID fourni")
    })
    BilanFinancierDTO findById(@PathVariable("idBilan") Integer idBilan);


    @ApiOperation(value = "renvoi la liste de bilanfinance",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des bilanfinance qui existent dans la BDD",
            responseContainer = "List<BilanFinancierDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des bilanfinance / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/bilanfinance/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<BilanFinancierDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/bilanfinance/delete/{idBilan}" )
    @ApiOperation(value = "supprimer  un bilanfinance ",notes = "Cette methode permet de supprimer"
            + " un bilanfinance par ID ",
            response = BilanFinancierDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "bilanfinance a ete supprimer"),
    })
    void delecte(@PathVariable("idBilan") Integer idBilan);
}
