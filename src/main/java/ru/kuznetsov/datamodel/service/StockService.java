package ru.kuznetsov.datamodel.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.datamodel.dto.StockDto;
import ru.kuznetsov.datamodel.mapper.StockMapper;
import ru.kuznetsov.datamodel.model.Stock;
import ru.kuznetsov.datamodel.repository.StockRepository;

@Service
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {
    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }
}
