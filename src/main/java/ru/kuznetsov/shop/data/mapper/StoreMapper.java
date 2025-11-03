package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.represent.dto.StoreDto;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.model.Store;
import ru.kuznetsov.shop.data.service.AddressService;

@Mapper(componentModel = "spring")
public abstract class StoreMapper implements AbstractMapper<Store, StoreDto> {
    @Autowired
    protected AddressService addressService;

    @Override
    @Mapping(target = "addressId", source = "entity.address.id")
    @Mapping(target = "address", source = "entity.address", qualifiedByName = "getAddressString")
    @Mapping(target = "ownerId", expression = "java(entity.getOwner().toString())")
    public abstract StoreDto entityToDto(Store entity);

    @Override
    @Mapping(target = "address", source = "dto.addressId", qualifiedByName = "idToAddress")
    @Mapping(target = "owner", expression = "java(UUID.fromString(dto.getOwnerId()))")
    public abstract Store dtoToEntity(StoreDto dto);

    @Named("getAddressString")
    protected String getAddressString(Address address) {
        return address.getAddressString();
    }

    @Named("idToAddress")
    protected Address idToAddress(Long id) {
        return addressService.findEntityById(id);
    }
}
