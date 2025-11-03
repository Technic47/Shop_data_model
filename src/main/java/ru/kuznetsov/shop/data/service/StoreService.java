package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.StoreDto;
import ru.kuznetsov.shop.data.mapper.StoreMapper;
import ru.kuznetsov.shop.data.model.Store;
import ru.kuznetsov.shop.data.repository.StoreRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StoreService extends AbstractService<Store, StoreDto, StoreRepository, StoreMapper> {
    protected StoreService(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

    public Store findEntityByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }

    public StoreDto findByName(String name){
        return entityMapper.entityToDto(findEntityByName(name));
    }

    public List<StoreDto> findByAddressId(Long addressId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByAddressId(addressId));
    }

    public List<StoreDto> findAllByOwnerId(UUID ownerId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOwner(ownerId));
    }
}
