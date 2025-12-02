package ru.kuznetsov.shop.data.mapper.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDToStringConverter {

    public String UUIDToString(UUID source) {
        return source == null ? "" : source.toString();
    }

    public UUID StringToUUID(String source) {
        return source == null ? null : UUID.fromString(source);
    }
}
