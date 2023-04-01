package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;


import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.FactureDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("facture")
public interface FactureApi {

	@PostMapping(value= APP_ROOT + "/facture/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	
	@ApiOperation(value = "Enregistrer une facture",notes = "Cette methode permet d'enresitrer ou"
			+ "  modifier une facture ", response = FactureDTO.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "l'objet facture cree / modifie")	
	})
	FactureDTO save(@RequestBody FactureDTO dto);
	
	@GetMapping(value= APP_ROOT + "/facture/{idFacture}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher d'une facture par ID",notes = "Cette methode permet de rechercher d'une facture par son ID ",
	response = FactureDTO.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "la facture a ete trouver dans la BDD"),	
		@ApiResponse(code = 404, message = "Aucun facture n'existe  dans la BDD avec l'ID fourni")	
		}) 
	FactureDTO findById(@PathVariable("idFacture")Integer idFacture);
	
	@GetMapping(value= APP_ROOT + "/facture/all", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "renvoi la liste du facture",notes = "Cette methode permet de rechercher et renvoyer la listes des facture qui existent dans la BDD",
	 responseContainer = "List<FactureDTO>")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des factures / une liste vide"),		
			})
	List<FactureDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT + "/facture/delete/{idFacture}" )
	 @ApiOperation(value = "supprimer une facture ",notes = "Cette methode permet de supprimer une facture par ID ",
 	 response = FactureDTO.class)
 	    @ApiResponses(value = {
 		@ApiResponse(code = 200, message = "la facture a ete supprimer"),	
 		})
	void delete(@PathVariable("idFacture")Integer idFacture);

}
