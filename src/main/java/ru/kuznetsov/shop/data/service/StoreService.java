package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.StoreMapper;
import ru.kuznetsov.shop.data.model.Store;
import ru.kuznetsov.shop.data.repository.StoreRepository;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.List;
import java.util.UUID;

@Service
@CacheConfig("STORE_CACHE")
public class StoreService extends AbstractService<Store, StoreDto, StoreRepository, StoreMapper> {

    protected StoreService(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "STORE_OPTIONAL_PARAMS", allEntries = true)
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public StoreDto add(StoreDto dto) {
        return super.add(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "STORE_OPTIONAL_PARAMS", allEntries = true)
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public StoreDto update(StoreDto dto) {
        return super.update(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "STORE_OPTIONAL_PARAMS", allEntries = true)
            }
    )
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Cacheable
    public StoreDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @Cacheable(key = "'ALL_VALUES'")
    public List<StoreDto> findAll() {
        return super.findAll();
    }

    @Cacheable("STORE_OPTIONAL_PARAMS")
    public List<StoreDto> findAllByOptionalParams(Long id,
                                                  String name,
                                                  Long addressId,
                                                  UUID ownerId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOptionalParams(id, name, addressId, ownerId));
    }

    public Store findEntityByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }
}
