package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;

import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.AnalyseMedicalDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api("analyseMedical")
public interface AnalyseMedicalApi {
	@PostMapping(value= APP_ROOT +"/analyseMedical/create", consumes = MediaType.APPLICATION_JSON_VALUE ,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer l'analyse medical",notes = "Cette methode permet d'enregistrer ou"
	+ "modifier un analyse medical",response = AnalyseMedicalDTO.class)
	    @ApiResponses(value = {
		@ApiResponse(code = 200, message = "l'objet analyse medical cree / modifie")	
	})
	AnalyseMedicalDTO save(@RequestBody AnalyseMedicalDTO dto);
	
	@GetMapping(value= APP_ROOT + "/analyseMedical/filter{idAnalyseMedical}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher un analyse medical par ID",notes = "Cette methode permet de rechercher  d'analyse medical par son ID ",
	response = AnalyseMedicalDTO.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "l'analyse medical a ete trouver dans la BDD"),	
		@ApiResponse(code = 404, message = "Aucun analyse medical  n'existe  dans la BDD avec l'ID fourni")	
		})
	
	AnalyseMedicalDTO findById(@PathVariable("idAnalyseMedical") Integer idAnalyseMedical);
	
	@GetMapping(value= APP_ROOT +"/analyseMedical/{dateAnalyse}", produces = MediaType.APPLICATION_JSON_VALUE )
	 
	@ApiOperation(value = "rechercher analyse medical par date ",notes = "Cette methode permet de rechercher un analyse medical par son date ",
	 response = AnalyseMedicalDTO.class)
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "l'analyse medical a ete trouver dans la BDD"),	
			@ApiResponse(code = 404, message = "Aucun analyse medical n'existe  dans la BDD avec le CODE fourni")	
			})
	AnalyseMedicalDTO findByDateAnalyse(@PathVariable("dateAnalyse")Date dateAnalyse);
	
	@GetMapping(value= APP_ROOT + "/analyseMedical/all", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "renvoi la liste d'analyse Medical",notes = "Cette methode permet de rechercher et renvoyer la listes d'analyse qui existent dans la BDD",
	 responseContainer = "List<AnalyseMedicalDTO>")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste d'analyse medical / une liste vide"),		
			})
	
	List<AnalyseMedicalDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT + "/analyseMedical/delete/{idAnalyseMedical}" )
	@ApiOperation(value = "supprimer  l'analyse Medical ",notes = "Cette methode permet de supprimer l'analyse Medical par ID ",
	 response = AnalyseMedicalDTO.class)
	    @ApiResponses(value = {
		@ApiResponse(code = 200, message = "analyse Medical a ete supprimer"),	
	    })
	   void delecte(@PathVariable("idAnalyseMedical")Integer idAnalyseMedical);
}
 