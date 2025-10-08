package ru.kuznetsov.data_model.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.data_model.dto.AddressDto;
import ru.kuznetsov.data_model.model.Address;

@Mapper(componentModel = "spring")
public abstract class AddressMapper implements AbstractMapper<Address, AddressDto> {
}
