package ru.kuznetsov.shop.data.mapper.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.data.mapper.AbstractMapper;
import ru.kuznetsov.shop.data.mapper.AddressMapper;
import ru.kuznetsov.shop.data.mapper.ProductCategoryMapper;
import ru.kuznetsov.shop.data.mapper.ProductMapper;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.model.order.Order;
import ru.kuznetsov.shop.data.service.AddressService;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ProductCategoryMapper.class, AddressMapper.class, BucketItemMapper.class})
public abstract class OrderMapper implements AbstractMapper<Order, OrderDto> {

    @Autowired
    protected AddressService addressService;

    @Override
    @Mapping(target = "deliveryAddressId", source = "deliveryAddress", qualifiedByName = "setDeliveryAddressToDto")
    public abstract OrderDto entityToDto(Order entity);

    @Override
    @Mapping(target = "deliveryAddress", source = "deliveryAddressId", qualifiedByName = "setDeliveryAddressToEntity")
    public abstract Order dtoToEntity(OrderDto dto);

    @Named("setDeliveryAddressToDto")
    protected Long setDeliveryAddressToDto(Address deliveryAddress) {
        return deliveryAddress == null ? null : deliveryAddress.getId();
    }

    @Named("setDeliveryAddressToEntity")
    protected Address setDeliveryAddressToEntity(Long deliveryAddressId) {
        return deliveryAddressId == null ? null : addressService.findEntityById(deliveryAddressId);
    }
}
