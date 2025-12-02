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
import ru.kuznetsov.shop.data.service.BucketItemService;
import ru.kuznetsov.shop.data.service.OrderStatusService;
import ru.kuznetsov.shop.represent.dto.order.BucketItemDto;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;
import ru.kuznetsov.shop.represent.dto.order.OrderStatusDto;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ProductCategoryMapper.class, AddressMapper.class, BucketItemMapper.class})
public abstract class OrderMapper implements AbstractMapper<Order, OrderDto> {

    @Autowired
    protected AddressService addressService;
    @Autowired
    protected BucketItemService bucketItemService;
    @Autowired
    protected OrderStatusService orderStatusService;

    @Override
    @Mapping(target = "deliveryAddressId", source = "deliveryAddress", qualifiedByName = "setDeliveryAddressToDto")
    @Mapping(target = "bucket", source = ".", qualifiedByName = "setBucketItems")
    @Mapping(target = "statusList", source = ".", qualifiedByName = "setStatusList")
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

    @Named("setBucketItems")
    protected Set<BucketItemDto> setBucketItems(Order entity) {
        return new HashSet<>(bucketItemService.getAllByOrderId(entity.getId()));
    }

    @Named("setStatusList")
    protected Set<OrderStatusDto> setStatusList(Order entity) {
        return new HashSet<>(orderStatusService.getAllByOrderId(entity.getId()));
    }
}
