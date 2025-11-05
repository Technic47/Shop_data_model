package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.StoreMapper;
import ru.kuznetsov.shop.data.model.Store;
import ru.kuznetsov.shop.data.repository.StoreRepository;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.List;
import java.util.UUID;

@Service
public class StoreService extends AbstractService<Store, StoreDto, StoreRepository, StoreMapper> {
    protected StoreService(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

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
