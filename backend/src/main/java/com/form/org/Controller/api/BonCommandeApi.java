package com.form.org.Controller.api;

import com.form.org.dto.AnalyseMedicalDTO;
import com.form.org.dto.BonCommandeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api("boncommande")
public interface BonCommandeApi {
    @PostMapping(value= APP_ROOT +"/boncommande/create", consumes = MediaType.APPLICATION_JSON_VALUE ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer boncommande",notes = "Cette methode permet d'enregistrer ou"
            + "modifier bonncommande",response = BonCommandeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet boncommande cree / modifie")
    })
    BonCommandeDTO save(@RequestBody BonCommandeDTO dto);


    @GetMapping(value= APP_ROOT + "/boncommande/filter{idBonCommande}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher boncommande par ID",notes = "Cette methode permet de rechercher  boncommande par son ID ",
            response = BonCommandeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "boncommandea ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "boncommande medical  n'existe  dans la BDD avec l'ID fourni")
    })
    BonCommandeDTO findById(@PathVariable("idBonCommande") Integer idBonCommande);


    @GetMapping(value= APP_ROOT +"/boncommande/{dateCommande}", produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "rechercher boncommande par date ",notes = "Cette methode permet de rechercher un boncommande par son date ",
            response = BonCommandeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "boncommande a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun boncommande n'existe  dans la BDD avec le CODE fourni")
    })
    BonCommandeDTO findByDateAnalyse(@PathVariable("dateCommande") Date dateCommande);


    @GetMapping(value= APP_ROOT + "/boncommande/all", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste boncommande",notes = "Cette methode permet de rechercher et renvoyer boncommande qui existent dans la BDD",
            responseContainer = "List<BonCommandeDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste boncommande/ une liste vide"),
    })
    List<BonCommandeDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/boncommande/delete/{idBonCommande}" )
    @ApiOperation(value = "supprimer  boncommande ",notes = "Cette methode permet de supprimer boncommande par ID ",
            response = BonCommandeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "boncommandea ete supprimer"),
    })
    void delecte(@PathVariable("idBonCommande")Integer idBonCommande);
}
