package com.form.org.Services;

import com.form.org.dto.ServiceFinanceDTO;

import java.util.List;

public interface ServiceFinanceService {
    ServiceFinanceDTO save(ServiceFinanceDTO dto);

    ServiceFinanceDTO findByidFinance(Integer idFinance);


    List<ServiceFinanceDTO> findAll();

    void delete(Integer idFinance);

}
