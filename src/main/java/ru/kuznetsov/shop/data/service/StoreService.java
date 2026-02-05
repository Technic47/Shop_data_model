package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @CachePut(key = "#dto.id")
    public StoreDto add(StoreDto dto) {
        return super.add(dto);
    }

    @Override
    @CachePut(key = "#dto.id")
    public StoreDto update(StoreDto dto) {
        return super.update(dto);
    }

    @Override
    @CacheEvict
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Cacheable
    public StoreDto findById(Long id) {
        return super.findById(id);
    }


    @Cacheable
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
