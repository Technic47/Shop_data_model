package ru.kuznetsov.shop.data.mapper;

import ru.kuznetsov.shop.data.model.AbstractEntity;
import ru.kuznetsov.shop.represent.dto.AbstractDto;

import java.util.List;

public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> allEntitiesToDtos(List<E> entities);

    List<E> allDtosToEntities(List<D> entities);
}
