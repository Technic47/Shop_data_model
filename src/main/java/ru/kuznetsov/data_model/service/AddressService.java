package ru.kuznetsov.data_model.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.data_model.dto.AddressDto;
import ru.kuznetsov.data_model.mapper.AddressMapper;
import ru.kuznetsov.data_model.model.Address;
import ru.kuznetsov.data_model.repository.AddressRepository;

@Service
public class AddressService extends AbstractService<Address, AddressDto, AddressRepository, AddressMapper> {
    protected AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }
}
