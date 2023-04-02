package com.form.org.Services;

import java.util.List;
import com.form.org.dto.ChangerMotDePasseUtilisateurDTO;
import com.form.org.dto.UtilisateurDTO;

public interface UtilisateurService {
	
	 UtilisateurDTO save(UtilisateurDTO dto);
		
	 UtilisateurDTO findById(Integer id);
		
	 List<UtilisateurDTO>findAll(); 
		
	 void delete(Integer id);
	 
	 UtilisateurDTO findByEmail(String email);
	 
	 UtilisateurDTO changerMotDePasse(ChangerMotDePasseUtilisateurDTO dto); 
	 
}
