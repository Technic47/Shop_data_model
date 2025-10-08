package ru.kuznetsov.data_model.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.data_model.dto.StockDto;
import ru.kuznetsov.data_model.mapper.StockMapper;
import ru.kuznetsov.data_model.model.Stock;
import ru.kuznetsov.data_model.repository.StockRepository;

@Service
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {
    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }
}
