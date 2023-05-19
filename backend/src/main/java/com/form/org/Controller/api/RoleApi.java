package com.form.org.Controller.api;

import com.form.org.dto.RolesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/roles")
public interface RoleApi {



    @PostMapping(value= APP_ROOT + "/role/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un role",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un role ", response = RolesDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet role cree / modifie")
    })
    RolesDTO save(@RequestBody RolesDTO dto);

    @GetMapping(value= APP_ROOT + "/role/{idRole}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un role par ID",notes = "Cette methode permet"
            + " de rechercher  un role par son ID ",response = RolesDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la patient a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun patient n'existe  dans la BDD avec l'ID fourni")
    })
    RolesDTO findById(@PathVariable("idRole") Integer idRole);


    @ApiOperation(value = "renvoi la liste de patient",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des patients qui existent dans la BDD",
            responseContainer = "List<RolesDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des roles / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/role/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<RolesDTO> findAll();

    @DeleteMapping(value =APP_ROOT + "/role/delete/{idRole}" )
    @ApiOperation(value = "supprimer  un patient ",notes = "Cette methode permet de supprimer"
            + " un role par ID ",
            response = RolesDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "patient a ete supprimer"),
    })
    void delecte(@PathVariable("idRole") Integer idRole);

}
