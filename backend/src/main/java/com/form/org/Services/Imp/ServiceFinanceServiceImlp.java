package com.form.org.Services.Imp;

import com.form.org.Repository.ServiceFinancierRepository;
import com.form.org.Services.ServiceFinanceService;
import com.form.org.dto.ServiceFinanceDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.model.ServiceFinance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServiceFinanceServiceImlp implements ServiceFinanceService {

    private ServiceFinancierRepository serviceFinancierRepository;

    @Autowired
    public ServiceFinanceServiceImlp(ServiceFinancierRepository serviceFinancierRepository) {
        this.serviceFinancierRepository = serviceFinancierRepository;
    }

    @Override
    public ServiceFinanceDTO save(ServiceFinanceDTO dto) {
        return ServiceFinanceDTO.fromEntity(
                serviceFinancierRepository.save(
                        ServiceFinanceDTO.toEntity(dto)));
    }

    @Override
    public ServiceFinanceDTO findByidFinance(Integer idFinance) {
        Optional<ServiceFinance> serviceFinance=serviceFinancierRepository.findByIdFinance(idFinance);

        return Optional.of(ServiceFinanceDTO.fromEntity(serviceFinance.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun service avec l'ID ="+ idFinance +"n'été trouve dans la BDD",
                        ErrorCodes.SERVICEFINANCE_NOT_FOUND));
    }

    @Override
    public List<ServiceFinanceDTO> findAll() {
        return serviceFinancierRepository.findAll().stream()
                .map(ServiceFinanceDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idFinance) {
        if(idFinance == null) {
            log.error("Srvicefinance id is null");
            return ;
        }

        serviceFinancierRepository.deleteById(idFinance);

    }
}
