package com.form.org.Controller.api;

import static com.form.org.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.UtilisateurDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("utilisateur")
public interface UtilisateurApi {
	@PostMapping(value= APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
	 @ApiOperation(value = "Enregistrer un utilisateur",notes ="Cette methode permet "
			    + "d'enregistrer ou modifier un utilisateur ", response = UtilisateurDTO.class)
				@ApiResponses(value = {
				@ApiResponse(code = 200, message = "l'objet utilisateur cree / modifie")	
				})
	UtilisateurDTO save(@RequestBody UtilisateurDTO dto);
	
	@GetMapping(value= APP_ROOT + "/utilisateur{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "rechercher un utilisateur par ID",notes = "Cette methode permet"
			+ " de rechercher  un utilisateur par son ID ",response = UtilisateurDTO.class)
			@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "la utilisateur a ete trouver dans la BDD"),	
			 @ApiResponse(code = 404, message = "Aucun utilisateur n'existe  dans la BDD avec l'ID fourni")	
				})
	UtilisateurDTO findById(@PathVariable("id")Integer id);
	
	@GetMapping(value= APP_ROOT + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE )
	@ApiOperation(value = "renvoi la liste de utilisateur",notes = "Cette methode permet"
			 + " de rechercher et renvoyer la listes des utilisateur qui existent dans la BDD",
			 responseContainer = "List<UtilisateurDTO>")
			@ApiResponses(value = {
			 @ApiResponse(code = 200, message = "la liste des utilisateur / une liste vide"),		
					})
	List<UtilisateurDTO>findAll(); 
		
	@DeleteMapping(value =APP_ROOT +"/utilisateur/delete/{id}" )
	@ApiOperation(value = "supprimer  un utilisateur ",notes = "Cette methode permet de supprimer"
		     + " un biologiste par ID ",
		 	 response = UtilisateurDTO.class)
		 	  @ApiResponses(value = {
		 	  @ApiResponse(code = 200, message = "utilisateur a ete supprimer"),	
		 		})
	void delete(@PathVariable("id") Integer id);

}
