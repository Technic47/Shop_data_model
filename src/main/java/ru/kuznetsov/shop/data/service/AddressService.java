package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.AddressDto;
import ru.kuznetsov.shop.data.mapper.AddressMapper;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.repository.AddressRepository;

import java.util.List;

@Service
@CacheConfig("ADDRESS_CACHE")
public class AddressService extends AbstractService<Address, AddressDto, AddressRepository, AddressMapper> {

    protected AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @CachePut(key = "#result.id")
    @CacheEvict(key = "'ALL_VALUES'")
    public AddressDto add(AddressDto dto) {
        return super.add(dto);
    }

    @Override
    @CachePut(key = "#result.id")
    @CacheEvict(key = "'ALL_VALUES'")
    public AddressDto update(AddressDto dto) {
        return super.update(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'ALL_VALUES'")
            }
    )
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Cacheable
    public AddressDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @Cacheable(key = "'ALL_VALUES'")
    public List<AddressDto> findAll() {
        return super.findAll();
    }
}
