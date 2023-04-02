package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.DepartementDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("departement")
public interface DepartementApi {
	
	@PutMapping(value= APP_ROOT + "/departement/update", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	@PostMapping(value= APP_ROOT + "/departement/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "Enregistrer un departement",notes = "Cette methode permet"
	+ " d'enregistrer ou modifier un departement ", response = DepartementDTO.class)
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "l'objet departement cree / modifie"),	
	@ApiResponse(code = 400, message = "l'objet departement n'est pas valide")
	})
	DepartementDTO save( @RequestBody DepartementDTO dto);

	@GetMapping(value= APP_ROOT + "/departement/{idDepartement}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher un departement par ID",
	notes ="Cette methode permet de rechercher  un departement par son ID ",response = DepartementDTO.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "la departement a ete trouver dans la BDD"),	
		@ApiResponse(code = 404, message = "Aucun departement n'existe  dans la BDD avec l'ID fourni")	
		})
	DepartementDTO findById(@PathVariable("idDepartement")Integer idDepartement);
	
	
	
	@GetMapping(value= APP_ROOT + "/departement/{nomDepartement}", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "rechercher un departement par nom de departement",notes = "Cette methode permet de rechercher un departement par son nom de departement ",
	 response = DepartementDTO.class)
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la departement a ete trouver dans la BDD"),	
			@ApiResponse(code = 404, message = "Aucun departement n'existe  dans la BDD avec le CODE fourni")	
			})
	DepartementDTO findByNomDeDepartement(@PathVariable("nomDepartement")String nomDepartement);
	
	@GetMapping(value= APP_ROOT + "/departement/all", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "renvoi la liste de departement",notes = "Cette methode permet de rechercher et renvoyer la listes des departement qui existent dans la BDD",
	 responseContainer = "List<DepartementDTO>")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des departement / une liste vide"),		
			})
	List<DepartementDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT +"/departements/delete/{idDepartement}" )
	 @ApiOperation(value = "supprimer un departement ",notes = "Cette methode permet de supprimer un departement par ID ",
 	 response = DepartementDTO.class)
 	    @ApiResponses(value = {
 		@ApiResponse(code = 200, message = "departement a ete supprimer"),	
 		})
	void delecte(@PathVariable("idDepartement")Integer idDepartement);

}
