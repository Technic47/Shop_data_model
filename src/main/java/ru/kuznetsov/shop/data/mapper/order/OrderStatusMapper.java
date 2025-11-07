package ru.kuznetsov.shop.data.mapper.order;

import org.mapstruct.Mapper;
import ru.kuznetsov.shop.data.mapper.AbstractMapper;
import ru.kuznetsov.shop.data.model.order.OrderStatus;
import ru.kuznetsov.shop.represent.dto.order.OrderStatusDto;

@Mapper(componentModel = "spring")
public abstract class OrderStatusMapper implements AbstractMapper<OrderStatus, OrderStatusDto> {

    @Override
    public abstract OrderStatusDto entityToDto(OrderStatus entity);

    @Override
    public abstract OrderStatus dtoToEntity(OrderStatusDto dto);
}
