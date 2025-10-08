package ru.kuznetsov.datamodel.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.datamodel.dto.AddressDto;
import ru.kuznetsov.datamodel.model.Address;

@Mapper(componentModel = "spring")
public abstract class AddressMapper implements AbstractMapper<Address, AddressDto> {
}
