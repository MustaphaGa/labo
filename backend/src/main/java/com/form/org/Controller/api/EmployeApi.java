package com.form.org.Controller.api;

import com.form.org.dto.EmployeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/employe")
public interface EmployeApi {
    @PostMapping(value= APP_ROOT + "/employe/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "Enregistrer un employe",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un employe ", response = EmployeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet employe cree / modifie")
    })
    EmployeDTO save(@RequestBody EmployeDTO dto);

    @GetMapping(value= APP_ROOT + "/employe/{idEmploye}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un employe par ID",notes = "Cette methode permet"
            + " de rechercher  un employe par son ID ",response = EmployeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la employe a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun employe n'existe  dans la BDD avec l'ID fourni")
    })
    EmployeDTO findById(@PathVariable("idEmploye") Integer idEmploye);

    @GetMapping(value= APP_ROOT + "/employe/filter{email}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un employe par email",notes = "Cette methode"
            + " permet de rechercher un employe par son email ",
            response = EmployeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la employe a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun employe n'existe  dans la BDD avec le CODE fourni")
    })
    EmployeDTO findByEmail(@PathVariable("email") String email);

    @ApiOperation(value = "renvoi la liste des emplyes",notes = "Cette methode permet"
            + " de rechercher et renvoyer la listes des employes qui existent dans la BDD",
            responseContainer = "List<EmployeDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 2000, message = "la liste des employes / une liste vide"),
    })
    @GetMapping(value= APP_ROOT + "/employe/all", produces = MediaType.APPLICATION_JSON_VALUE )
    List<EmployeDTO> findAll();


    @GetMapping(value= APP_ROOT + "/employe/CountEmploye", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "renvoi nombre employe",notes = "Cette methode permet de rechercher et renvoyer nombre employees qui existent dans la BDD",
            responseContainer = "List<EmployeDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "nombre employe / un nombre vide"),
    })
    Integer findCountEmploye();

    @DeleteMapping(value =APP_ROOT + "/employe/delete/{idEmploye}" )
    @ApiOperation(value = "supprimer  un employe ",notes = "Cette methode permet de supprimer"
            + " un employe par ID ",
            response = EmployeDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "employe a ete supprimer"),
    })
    void delete(@PathVariable("idEmploye") Integer idEmploye);
}


