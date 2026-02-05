package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.StockDto;
import ru.kuznetsov.shop.data.mapper.StockMapper;
import ru.kuznetsov.shop.data.model.Stock;
import ru.kuznetsov.shop.data.repository.StockRepository;

import java.util.List;
import java.util.UUID;

@Service
@CacheConfig("STOCK_CACHE")
public class StockService extends AbstractService<Stock, StockDto, StockRepository, StockMapper> {

    protected StockService(StockRepository repository, StockMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @CachePut(key = "#dto.id")
    public StockDto add(StockDto dto) {
        return super.add(dto);
    }

    @Override
    @CachePut(key = "#dto.id")
    public StockDto update(StockDto dto) {
        return super.update(dto);
    }

    @Override
    @CacheEvict
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Cacheable
    public StockDto findById(Long id) {
        return super.findById(id);
    }

    @Cacheable
    public List<StockDto> findAllByOptionalParams(Long productId, Long storeId, UUID ownerId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOptionalParams(productId, storeId, ownerId));
    }

    @Cacheable
    public List<StockDto> findAllByReservationOrderId(Long orderId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByReservationOrderId(orderId));
    }
}
