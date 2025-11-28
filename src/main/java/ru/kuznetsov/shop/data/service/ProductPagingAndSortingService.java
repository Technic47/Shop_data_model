package ru.kuznetsov.shop.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.ProductCardMapper;
import ru.kuznetsov.shop.data.repository.ProductPagingAndSortingRepository;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductPagingAndSortingService {

    private final ProductPagingAndSortingRepository repository;
    private final ProductCardMapper mapper;

    public Page<ProductCardDto> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::entityToDto);
    }

    public Page<ProductCardDto> findAllByCategoryOrOwnerIdPageable(UUID ownerId, Long categoryId, Pageable pageable) {
        return repository.findAllByOwnerIdOrCategoryPageable(ownerId, categoryId, pageable).map(mapper::entityToDto);
    }

    public Collection<ProductCardDto> findAllByCategoryOrOwnerId(UUID ownerId, Long categoryId) {
        return repository.findAllByOwnerIdOrCategory(ownerId, categoryId).stream().map(mapper::entityToDto).toList();
    }
}
