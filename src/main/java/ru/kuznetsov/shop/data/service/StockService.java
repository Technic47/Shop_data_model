package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.dto.StockDto;
import ru.kuznetsov.shop.data.mapper.StockMapper;
import ru.kuznetsov.shop.data.model.Stock;
import ru.kuznetsov.shop.data.repository.StockRepository;

import java.util.List;

@Service
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {
    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }

    public List<StockDto> findAllByStoreId(Long storeId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByStoreId(storeId));
    }

    public List<StockDto> findAllByProductId(Long productId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByProductId(productId));
    }
}
