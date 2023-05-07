package com.form.org.Services.Imp;

import com.form.org.Repository.BonCommandeRepository;
import com.form.org.Services.BonCommandeService;
import com.form.org.dto.AnalyseMedicalDTO;
import com.form.org.dto.BonCommandeDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.AnalyseMedical;
import com.form.org.model.BonCommande;
import com.form.org.validator.AnalyseMedicalValidator;
import com.form.org.validator.BonCommandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BonCommandeServiceImpml implements BonCommandeService {
    private BonCommandeRepository bonCommandeRepository;

    @Autowired
    public BonCommandeServiceImpml(BonCommandeRepository bonCommandeRepository) {
        this.bonCommandeRepository = bonCommandeRepository;
    }

    @Override
    public BonCommandeDTO save(BonCommandeDTO dto) {
        List<String> errors= BonCommandeValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("boncommande n'est pas valide {}",dto);
            throw new InvalidEntityException("boncommande n'est pas valide", ErrorCodes.BONCOMMANDE_NOT_VALID, errors);
        }
        return BonCommandeDTO.fromEntity(
                bonCommandeRepository.save(
                        BonCommandeDTO.toEntity(dto)
                )
        );    }

    @Override
    public BonCommandeDTO findById(Integer idBonCommande) {
        if(idBonCommande == null) {
            log.error("Boncommande id is null");
            return null;
        }
        Optional<BonCommande> bonCommande=bonCommandeRepository.findById(idBonCommande);

        return Optional.of(BonCommandeDTO.fromEntity(bonCommande.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun boncommade avec l'ID ="+ idBonCommande +"n'été trouve dans la BDD",
                        ErrorCodes.BONCOMMANDE_NOT_FOUND)
        );
    }

    @Override
    public BonCommandeDTO findByDateCommande(Date dateCommande) {
        if(dateCommande == null){
            log.error("date commande is null");
            return null;
        }
        Optional<BonCommande> bonCommande=bonCommandeRepository.findByDateCommande(dateCommande);

        return Optional.of(BonCommandeDTO.fromEntity(bonCommande.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun datecommande  dans ce date ="+ dateCommande +"n'été trouve dans la BDD",
                        ErrorCodes.BONCOMMANDE_NOT_FOUND)
        );
    }

    @Override
    public List<BonCommandeDTO> findAll() {
        return bonCommandeRepository.findAll().stream()
                .map(BonCommandeDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idBonCommande) {
        if(idBonCommande == null) {
            log.error("boncommandeid is null");
            return ;
        }
        bonCommandeRepository.deleteById(idBonCommande);

    }
}
