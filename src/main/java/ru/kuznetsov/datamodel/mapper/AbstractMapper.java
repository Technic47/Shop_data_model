package ru.kuznetsov.datamodel.mapper;

import ru.kuznetsov.datamodel.dto.AbstractDto;
import ru.kuznetsov.datamodel.model.AbstractEntity;

import java.util.List;

public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> allEntitiesToDtos(List<E> entities);

    List<E> allDtosToEntities(List<D> entities);
}
