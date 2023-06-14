package com.form.org.Controller.api;

import com.form.org.dto.ReservationDTO;
import com.form.org.dto.StockDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api("stock")
public interface StockApi {

    @PostMapping(value= APP_ROOT + "/stock/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un stock",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un stock ", response = StockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet reservation cree / modifie")
    })
    StockDTO save(@RequestBody StockDTO dto);

    @GetMapping(value= APP_ROOT + "/stock/{idStock}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un stock par ID",notes = "Cette methode permet"
            + " de rechercher  un stock par son ID ",response = StockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la stock a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun stock n'existe  dans la BDD avec l'ID fourni")
    })
    StockDTO findById(@PathVariable("idStock")Integer idStock);


    @GetMapping(value= APP_ROOT + "/stock/filter{dateStock}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un stock par date de Stock",notes = "Cette methode"
            + " permet de rechercher un stock par date de Stock  ",
            response = StockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la stock a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun stock n'existe  dans la BDD avec le CODE fourni")
    })
    StockDTO findBydateStock(@PathVariable("dateStock") Date dateStock);


    @GetMapping(value= APP_ROOT + "/stock/all", produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "renvoi la liste de stock",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des stock qui existent dans la BDD",
            responseContainer = "List<ReservationDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des stock / une liste vide"),
    })
    List<StockDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/stock/delete/{idStock}" )
    @ApiOperation(value = "supprimer  un stock ",notes = "Cette methode permet de supprimer"
            + " un stock par ID ",
            response = StockDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "reservation a ete supprimer"),
    })
    void delete(@PathVariable("idStock") Integer idStock);
}
