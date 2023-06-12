package com.form.org.Controller.api;

import com.form.org.dto.CompteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/compte")
public interface CompteApi {

    @PostMapping(value= APP_ROOT + "/compte/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer Compte",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un compte ", response = CompteDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet compte crée / modifie")
    })
    CompteDTO save(@RequestBody CompteDTO dto);


    @GetMapping(value= APP_ROOT + "/compte/{idCompte}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un compte par ID",notes = "Cette methode permet"
            + " de rechercher  un compte par son ID ",response = CompteDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "compte a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun compte n'existe  dans la BDD avec l'ID fourni")
    })
    CompteDTO findById(@PathVariable("idCompte") Integer idCompte);



    @GetMapping(value= APP_ROOT + "/compte/all", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi la liste des compte",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des compte qui existent dans la BDD",
            responseContainer = "List<CompteDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des compte / une liste vide"),
    })
    List<CompteDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/compte/delete/{idCompte}" )
    @ApiOperation(value = "supprimer  un compte ",notes = "Cette methode permet de supprimer"
            + " un compte par ID ",
            response = CompteDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "compte a été supprimer"),
    })
    void delete(@PathVariable("idCompte") Integer idCompte);
}
