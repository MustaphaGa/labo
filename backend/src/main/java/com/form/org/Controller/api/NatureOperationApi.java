package com.form.org.Controller.api;

import com.form.org.dto.NatureOperationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.form.org.utils.Constants.APP_ROOT;

@Api("natureOperation")
public interface NatureOperationApi {

	 @PostMapping(value= APP_ROOT + "/natureOperation/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "Enregistrer un nature d'operation",notes ="Cette methode permet "
		+ "d'enregistrer ou modifier un nature d'operation ", response = NatureOperationDTO.class)
	  @ApiResponses(value = {
	  @ApiResponse(code = 200, message = "l'objet natureOperation cree/modifie")
				})
	 NatureOperationDTO save(@RequestBody NatureOperationDTO dto);

	 @GetMapping(value= APP_ROOT + "/natureOperation/{idNatureOperation}", produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "rechercher un nature d'operation par ID",notes = "Cette methode permet"
				+ " de rechercher  un nature d'operation par son ID ",response = NatureOperationDTO.class)
				@ApiResponses(value = {
				 @ApiResponse(code = 200, message = "la nature d'operation a ete trouver dans la BDD"),
				 @ApiResponse(code = 404, message = "Aucun nature d'operation n'existe  dans la BDD avec l'ID fourni")
					})
	 NatureOperationDTO findById(@PathVariable("idNatureOperation") Integer idNatureOperation);

	 
	 @GetMapping(value= APP_ROOT + "/natureOperation/all", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ApiOperation(value = "renvoi la liste de nature d'operation",notes = "Cette methode permet"
			 + " de rechercher et renvoyer la listes des natures d'operation qui existent dans la BDD",
			 responseContainer = "List<NatureOperationDTO>")
			@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "la liste des natures d'operation / une liste vide"),
					})
	 List<NatureOperationDTO>findAll();
	 
	 @DeleteMapping(value =APP_ROOT + "/natureOperation/delete/{idNatureOperation}" )
	 @ApiOperation(value = "supprimer un nature d'operation",notes = "Cette methode permet de supprimer"
		     + " un nature d'operation par ID ",
		 	 response = NatureOperationDTO.class)
		 	  @ApiResponses(value = {
		 	  @ApiResponse(code = 200, message = "Nature d'operation a été supprimer"),
		 		})
	 void delecte(@PathVariable("idNatureOperation") Integer idNatureOperation);

}
