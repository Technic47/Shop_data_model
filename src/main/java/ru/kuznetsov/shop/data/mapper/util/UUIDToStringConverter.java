package ru.kuznetsov.shop.data.mapper.util;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class UUIDToStringConverter implements Converter<UUID, String> {

    @Override
    public String convert(UUID source) {
        return source.toString();
    }
}
