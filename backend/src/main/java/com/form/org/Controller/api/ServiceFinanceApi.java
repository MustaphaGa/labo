package com.form.org.Controller.api;

import com.form.org.dto.RhDTO;
import com.form.org.dto.ServiceFinanceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/servicefinance")
public interface ServiceFinanceApi {


    @PostMapping(value= APP_ROOT + "/servicefinance/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un servicefinance",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un servicefinance ", response = ServiceFinanceDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet servicefinance cree / modifie")
    })
    ServiceFinanceDTO save(@RequestBody ServiceFinanceDTO dto);

    @GetMapping(value= APP_ROOT + "/servicefinance/{idFinance}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un servicefinance par ID",notes = "Cette methode permet"
            + " de rechercher  un servicefinance par son ID ",response = ServiceFinanceDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " servicefinance a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun servicefinance n'existe  dans la BDD avec l'ID fourni")
    })
    ServiceFinanceDTO findById(@PathVariable("idFinance") Integer idFinance);


    @ApiOperation(value = "renvoi la liste de servicefinance",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des servicefinance qui existent dans la BDD",
            responseContainer = "List<ServiceFinanceDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des servicefinance / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/servicefinance/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<ServiceFinanceDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/servicefinance/delete/{idFinance}" )
    @ApiOperation(value = "supprimer  un servicefinance ",notes = "Cette methode permet de supprimer"
            + " un servicefinance par ID ",
            response = RhDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "rh a ete supprimer"),
    })
    void delecte(@PathVariable("idFinance") Integer idFinance);
}
