package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.StockDto;
import ru.kuznetsov.shop.data.mapper.StockMapper;
import ru.kuznetsov.shop.data.model.Stock;
import ru.kuznetsov.shop.data.repository.StockRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {
    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }

    public List<StockDto> findAllByOptionalParams(Long productId, Long storeId, UUID ownerId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOptionalParams(productId, storeId, ownerId));
    }
}
