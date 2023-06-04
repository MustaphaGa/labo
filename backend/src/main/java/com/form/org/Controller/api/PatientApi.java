package com.form.org.Controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.form.org.dto.PatientDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import static com.form.org.utils.Constants.APP_ROOT;

@Api(APP_ROOT +"/patient")
public interface PatientApi{
	
	@PostMapping(value= APP_ROOT + "/patient/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "Enregistrer un patient",notes ="Cette methode permet "
	 + "d'enregistrer ou modifier un patient ", response = PatientDTO.class)
	  @ApiResponses(value = {
	  @ApiResponse(code = 200, message = "l'objet patient cree / modifie")	
				})
	PatientDTO save(@RequestBody PatientDTO dto);
	
	@GetMapping(value= APP_ROOT + "/patient/{idPatient}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher un patient par ID",notes = "Cette methode permet"
	+ " de rechercher  un patient par son ID ",response = PatientDTO.class)
	@ApiResponses(value = {
	 @ApiResponse(code = 200, message = "la patient a ete trouver dans la BDD"),	
	 @ApiResponse(code = 404, message = "Aucun patient n'existe  dans la BDD avec l'ID fourni")	
				})
	PatientDTO findById(@PathVariable("idPatient") Integer idPatient);
	
	@GetMapping(value= APP_ROOT + "/patient/filter{codePatient}", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "rechercher un patient par CODE",notes = "Cette methode"
			 + " permet de rechercher un patient par son CODE ",
			 response = PatientDTO.class)
				@ApiResponses(value = {
				 @ApiResponse(code = 200, message = "la patient a ete trouver dans la BDD"),	
				 @ApiResponse(code = 404, message = "Aucun patient n'existe  dans la BDD avec le CODE fourni")	
					})
	PatientDTO findPatientByCodePatient(@PathVariable("codePatient") String codePatient);
	
	@ApiOperation(value = "renvoi la liste de patient",notes = "Cette methode permet"
	 + " de rechercher et renvoyer la listes des patients qui existent dans la BDD",
	 responseContainer = "List<PatientDTO>")
	@ApiResponses(value = {
	@ApiResponse(code = 2000, message = "la liste des patients / une liste vide"),		
					})
	@GetMapping(value= APP_ROOT + "/patient/all", produces = MediaType.APPLICATION_JSON_VALUE )
	
	List<PatientDTO>findAll();
	
	 @DeleteMapping(value =APP_ROOT + "/patient/delete/{idPatient}" )
	 @ApiOperation(value = "supprimer  un patient ",notes = "Cette methode permet de supprimer"
		     + " un patient par ID ",
		 	 response = PatientDTO.class)
		 	  @ApiResponses(value = {
		 	  @ApiResponse(code = 200, message = "patient a ete supprimer"),	
		 		})
	void delete(@PathVariable("idPatient") Integer idPatient);

}


