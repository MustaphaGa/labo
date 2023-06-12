package com.form.org.Controller;

import com.form.org.Controller.api.FournisseurApi;
import com.form.org.Services.FournisseurService;
import com.form.org.dto.FournisseurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
                this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDTO save(FournisseurDTO dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDTO findById(Integer idFournisseur) {
        return fournisseurService.findById(idFournisseur);
    }

   /*
    @Override
    public FournisseurDTO findByNom(String nom) {
        return fournisseurService.findByNom(nom);
    }
    */

    @Override
    public List<FournisseurDTO> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer idFournisseur) {
        fournisseurService.delete(idFournisseur);

    }
}
