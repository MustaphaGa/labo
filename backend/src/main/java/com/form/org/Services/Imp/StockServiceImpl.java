package com.form.org.Services.Imp;

import com.form.org.Repository.StockRepository;
import com.form.org.Services.StockService;
import com.form.org.dto.StockDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockDTO save(StockDTO dto) {
        return StockDTO.fromEntity(
                stockRepository.save(
                        StockDTO.toEntity(dto)));
    }

    @Override
    public StockDTO findById(Integer idStock) {
        if(idStock == null) {
            log.error("reservation id is null");
            return null;
        }
        Optional<Stock> stock=stockRepository.findById(idStock);

        return Optional.of(StockDTO.fromEntity(stock.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun reservation avec l'ID ="+ idStock +"n'été trouve dans la BDD",
                        ErrorCodes.RESERVATION_NOT_FOUND)
        );
    }

    @Override
    public StockDTO findBydateVerification(Date dateVerification) {

        if(dateVerification == null){
            log.error(" date de reservation null");
            return null;
        }

        Optional<Stock> stock=stockRepository.findBydateVerification(dateVerification);

        return Optional.of(StockDTO.fromEntity(stock.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun reservation avec cette date ="+ dateVerification +"n'été trouve dans la BDD",
                        ErrorCodes.RESERVATION_NOT_FOUND)
        );
    }

    @Override
    public List<StockDTO> findAll() {
        return stockRepository.findAll().stream()
                .map(StockDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idStock) {
        if(idStock == null) {
            log.error("reservation id is null");
            return ;
        }

        stockRepository.deleteById(idStock);

    }
}
