package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.dto.StoreDto;
import ru.kuznetsov.shop.data.mapper.StoreMapper;
import ru.kuznetsov.shop.data.model.Store;
import ru.kuznetsov.shop.data.repository.StoreRepository;

@Service
public class StoreService extends AbstractService<Store, StoreDto, StoreRepository, StoreMapper> {
    protected StoreService(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

    public Store findByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }
}
