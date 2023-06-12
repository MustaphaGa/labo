package com.form.org.Services.Imp;
import com.form.org.Repository.CompteRepository;
import com.form.org.Services.CompteService;
import com.form.org.dto.CompteDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.model.Compte;
import com.form.org.validator.CompteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompteServiceImpl implements CompteService {
    private CompteRepository compteRepository;

    @Autowired
    public  CompteServiceImpl(CompteRepository compteRepository)
    {
        this.compteRepository=compteRepository;
    }

    @Override
    public CompteDTO save(CompteDTO dto) {
        List<String> errors= CompteValidator.validate(dto);
        if(!errors.isEmpty())
        {
            log.error(" compte n'est pas valide {}",dto);
            throw new InvalidEntityException(" compte n'est pas valide", ErrorCodes.COMPTE_NOT_VALID, errors);
        }
        return CompteDTO.fromEntity(
                compteRepository.save(CompteDTO.toEntity(dto))
        );
    }


    @Override
    public CompteDTO findById(Integer idCompte) {

        if(idCompte == null) {
            log.error("Compte id is null");
            return null;
        }
        Optional<Compte> compte=compteRepository.findById(idCompte);
        return Optional.of(CompteDTO.fromEntity(compte.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun compte avec l'ID ="+ idCompte +"n'été trouve dans la BDD",
                        ErrorCodes.COMPTE_NOT_FOUND)
        );
    }


    @Override
    public List<CompteDTO> findAll() {
        return compteRepository.findAll().stream()
                .map(CompteDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idCompte) {
        if(idCompte == null)
        {
            log.error("preleveur id is null");
            return ;
        }
     compteRepository.deleteById(idCompte);

    }
}
