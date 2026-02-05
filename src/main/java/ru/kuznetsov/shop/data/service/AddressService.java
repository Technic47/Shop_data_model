package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.AddressDto;
import ru.kuznetsov.shop.data.mapper.AddressMapper;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.repository.AddressRepository;

@Service
@CacheConfig("ADDRESS_CACHE")
public class AddressService extends AbstractService<Address, AddressDto, AddressRepository, AddressMapper> {

    protected AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @CachePut(key = "#dto.id")
    public AddressDto add(AddressDto dto) {
        return super.add(dto);
    }

    @Override
    @CachePut(key = "#dto.id")
    public AddressDto update(AddressDto dto) {
        return super.update(dto);
    }

    @Override
    @CacheEvict
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Cacheable
    public AddressDto findById(Long id) {
        return super.findById(id);
    }
}
