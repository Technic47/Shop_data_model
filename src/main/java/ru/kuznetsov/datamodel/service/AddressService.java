package ru.kuznetsov.datamodel.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.datamodel.dto.AddressDto;
import ru.kuznetsov.datamodel.mapper.AddressMapper;
import ru.kuznetsov.datamodel.model.Address;
import ru.kuznetsov.datamodel.repository.AddressRepository;

@Service
public class AddressService extends AbstractService<Address, AddressDto, AddressRepository, AddressMapper> {
    protected AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }
}
