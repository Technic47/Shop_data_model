package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.dto.AddressDto;
import ru.kuznetsov.shop.data.mapper.AddressMapper;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.repository.AddressRepository;

@Service
public class AddressService extends AbstractService<Address, AddressDto, AddressRepository, AddressMapper> {
    protected AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }
}
