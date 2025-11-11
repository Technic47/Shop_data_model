package ru.kuznetsov.shop.data.mapper.order;

import org.mapstruct.Mapper;
import ru.kuznetsov.shop.data.mapper.AbstractMapper;
import ru.kuznetsov.shop.data.model.order.BucketItem;
import ru.kuznetsov.shop.represent.dto.order.BucketItemDto;

@Mapper(componentModel = "spring")
public abstract class BucketItemMapper implements AbstractMapper<BucketItem, BucketItemDto> {
}
