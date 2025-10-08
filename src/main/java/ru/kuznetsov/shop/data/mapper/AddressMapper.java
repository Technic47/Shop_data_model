package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.shop.data.dto.AddressDto;
import ru.kuznetsov.shop.data.model.Address;

@Mapper(componentModel = "spring")
public abstract class AddressMapper implements AbstractMapper<Address, AddressDto> {
}
