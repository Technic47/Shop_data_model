package ru.kuznetsov.shop.data.mapper.util;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        return UUID.fromString(source);
    }
}
