package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.form.org.dto.LaboDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(APP_ROOT +"/labo")
public interface LaboApi {
	
	@PostMapping(value=APP_ROOT +"/labo/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE  )
	@ApiOperation(value = "Enregistrer un labo",notes ="Cette methode permet "
            + "d'enregistrer ou modifier un labo ", response = LaboDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet patient cree / modifie")
    })
	LaboDTO save(@RequestBody LaboDTO dto);
	
	
	
	@GetMapping(value= APP_ROOT + "/labo/{idLabo}", produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "rechercher un labo par ID",notes = "Cette methode permet"
            + " de rechercher  un labo par son ID ",response = LaboDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " labo a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun labo n'existe  dans la BDD avec l'ID fourni")
    })
	LaboDTO findById(Integer idLabo);
	
	
	
	   @ApiOperation(value = "renvoi la liste de labo",notes = "Cette methode permet"
	            + " de rechercher et renvoyer la listes des labos qui existent dans la BDD",
	            responseContainer = "List<laboDTO>")
	    @ApiResponses(value = {
	            @ApiResponse(code = 2000, message = "la liste des labos / une liste vide"),
	    })
	    @GetMapping(value= APP_ROOT + "/labo/all", produces = MediaType.APPLICATION_JSON_VALUE )
	List<LaboDTO> findAll();
	
	   
	   
	   @DeleteMapping(value =APP_ROOT + "/labo/delete/{idLabo}" )
	    @ApiOperation(value = "supprimer  un labo ",notes = "Cette methode permet de supprimer"
	            + " un labo par ID ",
	            response = LaboDTO.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "labo  a ete supprimer"),
	    })
	void delete(Integer idLabo);


}
