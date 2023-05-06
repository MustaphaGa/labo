package com.form.org.Services.Imp;

import com.form.org.Repository.LaboRepository;
import com.form.org.Repository.RolesRepository;
import com.form.org.Services.EmployeService;
import com.form.org.Services.LaboService;
import com.form.org.dto.EmployeDTO;
import com.form.org.dto.LaboDTO;
import com.form.org.dto.RolesDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.exception.InvalidEntityException;
import com.form.org.validator.LaboValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class LaboServiceImpl implements LaboService {

    private LaboRepository laboRepository;
    //private EmployeService employeService;
  // private RolesRepository rolesRepository;
    @Autowired
    public LaboServiceImpl(LaboRepository laboRepository, EmployeService employeService,
                                 RolesRepository rolesRepository) {
        this.laboRepository = laboRepository;
        //this.employeService = employeService;
       // this.rolesRepository = rolesRepository;
    }

    @Override
    public LaboDTO save(LaboDTO dto) {
        List<String> errors = LaboValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Labo is not valid {}", dto);
            throw new InvalidEntityException("Labo n'est pas valide", ErrorCodes.LABO_NOT_FOUND, errors);
        }
        LaboDTO savedLabo = LaboDTO.fromEntity(
                laboRepository.save(LaboDTO.toEntity(dto))
        );

        EmployeDTO employe = fromLabo(savedLabo);

       // EmployeDTO savedUser = employeService.save(employe);

        RolesDTO rolesDto = RolesDTO.builder()
                .roleName("ADMIN")
              //  .employe(savedUser)
                .build();

        //rolesRepository.save(RolesDTO.toEntity(rolesDto));

        return  savedLabo;
    }
  private EmployeDTO fromLabo(LaboDTO dto) {
        return EmployeDTO.builder()
                .nom(dto.getNomLabo())
                .prenom(dto.getCodeFiscal())
                .email(dto.getEmail())
                .password(generateRandomPassword())
                .labo(dto)
                .date_embauchDate(Instant.now())
                .photo(dto.getSiteWeb())
                .build();
    }
    private String generateRandomPassword() {
        return "som3R@nd0mP@$$word";
    }

    @Override
    public LaboDTO findById(Integer idLabo) {
        if (idLabo == null) {
            log.error("labo ID is null");
            return null;
        }
        return laboRepository.findById(idLabo)
                .map(LaboDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune labo avec l'ID = " + idLabo + " n' ete trouve dans la BDD",
                        ErrorCodes.LABO_NOT_FOUND)
                );
    }

    @Override
    public List<LaboDTO> findAll() {
        return laboRepository.findAll().stream()
                .map(LaboDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idLabo) {
        if (idLabo == null) {
            log.error("labo ID is null");
            return;
        }
        laboRepository.deleteById(idLabo);

    }
}
