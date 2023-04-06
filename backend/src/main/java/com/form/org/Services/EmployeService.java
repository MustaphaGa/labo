package com.form.org.Services;

import java.util.List;

import com.form.org.dto.ChangerMotDePasseUtilisateurDTO;
import com.form.org.dto.EmployeDTO;

public interface EmployeService {
	
EmployeDTO save(EmployeDTO dto);
		
EmployeDTO findById(Integer idEmploye);
		
	 List<EmployeDTO>findAll(); 
		
	 void delete(Integer idEmploye);
	 
	 EmployeDTO findByEmail(String email);
	 
	 EmployeDTO changerMotDePasse(ChangerMotDePasseUtilisateurDTO dto); 

}
