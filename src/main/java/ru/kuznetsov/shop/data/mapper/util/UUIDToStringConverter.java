package ru.kuznetsov.shop.data.mapper.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDToStringConverter {

    public String UUIDToString(UUID source) {
        return source.toString();
    }

    public UUID StringToUUID(String source) {
        return UUID.fromString(source);
    }
}
