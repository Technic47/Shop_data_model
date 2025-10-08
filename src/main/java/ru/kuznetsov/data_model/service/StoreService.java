package ru.kuznetsov.data_model.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.data_model.dto.StoreDto;
import ru.kuznetsov.data_model.mapper.StoreMapper;
import ru.kuznetsov.data_model.model.Store;
import ru.kuznetsov.data_model.repository.StoreRepository;

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
