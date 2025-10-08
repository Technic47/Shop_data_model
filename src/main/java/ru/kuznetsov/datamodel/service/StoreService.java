package ru.kuznetsov.datamodel.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.datamodel.dto.StoreDto;
import ru.kuznetsov.datamodel.mapper.StoreMapper;
import ru.kuznetsov.datamodel.model.Store;
import ru.kuznetsov.datamodel.repository.StoreRepository;

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
