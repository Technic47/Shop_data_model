package ru.kuznetsov.data_model.mapper;

import ru.kuznetsov.data_model.dto.AbstractDto;
import ru.kuznetsov.data_model.model.AbstractEntity;

import java.util.List;

public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> allEntitiesToDtos(List<E> entities);

    List<E> allDtosToEntities(List<D> entities);
}
