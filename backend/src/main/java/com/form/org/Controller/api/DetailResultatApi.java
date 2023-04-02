package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;



import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.DetailResultatDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("detailResultat")
public interface DetailResultatApi {
	
	@PostMapping(value= APP_ROOT + "/detailResultat/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "Enregistrer un detail Resultat",notes = "Cette methode permet d'enregistrer ou"
			+ "  modifier un detailResultat ", response = DetailResultatDTO.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "l'objet detail Resultat cree / modifie")	
	})
	DetailResultatDTO save(@RequestBody DetailResultatDTO dto);

	@GetMapping(value= APP_ROOT + "/detailResultat/{idDetailResultat}", produces = MediaType.APPLICATION_JSON_VALUE )
	
	@ApiOperation(value = "rechercher un detail Resultat par ID",notes = "Cette methode permet de rechercher  un detail Resultat par son ID ",
	response = DetailResultatDTO.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "la detail Resultat a ete trouver dans la BDD"),	
		@ApiResponse(code = 404, message = "Aucun detail Resultat n'existe  dans la BDD avec l'ID fourni")	
		})
	DetailResultatDTO findById(@PathVariable("idDetailResultat")Integer idDetailResultat);
	
	@GetMapping(value= APP_ROOT + "/detailResultat/all", produces = MediaType.APPLICATION_JSON_VALUE )
	
	@ApiOperation(value = "renvoi la liste de detail Resultat",notes = "Cette methode permet de rechercher et renvoyer la listes des detail Resultats qui existent dans la BDD",
	 responseContainer = "List<DetailResultatDTO>")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "la liste des biologiste / une liste vide"),		
			})
	List<DetailResultatDTO>findAll(); 
	
	@DeleteMapping(value =APP_ROOT + "/detailResultat/delete/{idDetailResultat}" )
	
	 @ApiOperation(value = "supprimer  un detail Resultat ",notes = "Cette methode permet de supprimer un detail Resultat par ID ",
 	 response = DetailResultatDTO.class)
 	    @ApiResponses(value = {
 		@ApiResponse(code = 200, message = "detail Resultat a ete supprimer"),	
 		})
	void delecte(@PathVariable("idDetailResultat")Integer idDetailResultat);

}
