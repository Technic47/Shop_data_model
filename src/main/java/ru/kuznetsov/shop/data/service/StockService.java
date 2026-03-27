package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.*;
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
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "STOCK_OPTIONAL_PARAMS", allEntries = true),
                    @CacheEvict(value = "STOCK_RESERVATION", allEntries = true)
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public StockDto add(StockDto dto) {
        return super.add(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "STOCK_OPTIONAL_PARAMS", allEntries = true),
                    @CacheEvict(value = "STOCK_RESERVATION", allEntries = true)
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public StockDto update(StockDto dto) {
        return super.update(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "STOCK_OPTIONAL_PARAMS", allEntries = true),
                    @CacheEvict(value = "STOCK_RESERVATION", allEntries = true)
            }
    )
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Cacheable(unless="#result == null")
    public StockDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @Cacheable(key = "'ALL_VALUES'")
    public List<StockDto> findAll() {
        return super.findAll();
    }

    @Cacheable("STOCK_OPTIONAL_PARAMS")
    public List<StockDto> findAllByOptionalParams(Long productId, Long storeId, UUID ownerId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOptionalParams(productId, storeId, ownerId));
    }

    @Cacheable("STOCK_RESERVATION")
    public List<StockDto> findAllByReservationOrderId(Long orderId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByReservationOrderId(orderId));
    }
}
