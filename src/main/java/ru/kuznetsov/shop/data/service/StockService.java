package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.dto.StockDto;
import ru.kuznetsov.shop.data.mapper.StockMapper;
import ru.kuznetsov.shop.data.model.Stock;
import ru.kuznetsov.shop.data.repository.StockRepository;

@Service
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {
    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }
}
