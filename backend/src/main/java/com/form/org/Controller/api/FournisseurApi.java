package com.form.org.Controller.api;

import com.form.org.dto.FactureDTO;
import com.form.org.dto.FournisseurDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api("fournisseur")
public interface FournisseurApi {

    @PostMapping(value= APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )

    @ApiOperation(value = "Enregistrer une fournisseur",notes = "Cette methode permet d'enresitrer ou"
            + "  modifier une fournisseur ", response = FournisseurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet fournisseur cree / modifie")
    })
    FournisseurDTO save(@RequestBody FournisseurDTO dto);


    @GetMapping(value= APP_ROOT + "/fournisseur/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher d'une fournisseur par ID",notes = "Cette methode permet de rechercher d'une fournisseur par son ID ",
            response = FournisseurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la fournisseur a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun fournisseur n'existe  dans la BDD avec l'ID fourni")
    })
    FournisseurDTO findById(@PathVariable("idFournisseur")Integer idFournisseur);





    @GetMapping(value= APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste du facture",notes = "Cette methode permet de rechercher et renvoyer la listes des facture qui existent dans la BDD",
            responseContainer = "List<FournisseurDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des factures / une liste vide"),
    })
    List<FournisseurDTO> findAll();


    @DeleteMapping(value =APP_ROOT + "/fournisseur/delete/{idFournisseur}" )
    @ApiOperation(value = "supprimer une fournisseur ",notes = "Cette methode permet de supprimer une fournisseur par ID ",
            response = FournisseurDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la fournisseur a ete supprimer"),
    })
    void delete(@PathVariable("idFournisseur")Integer idFournisseur);

}
