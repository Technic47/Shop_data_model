package ru.kuznetsov.shop.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.ProductCardMapper;
import ru.kuznetsov.shop.data.model.util.RestPage;
import ru.kuznetsov.shop.data.repository.ProductPagingAndSortingRepository;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductPagingAndSortingService {

    private final ProductPagingAndSortingRepository repository;
    private final ProductCardMapper mapper;

    @Cacheable("PRODUCT_CARD_PAGE_CACHE")
    public RestPage<ProductCardDto> findAllPageable(Pageable pageable) {
        return new RestPage<>(repository.findAll(pageable).map(mapper::entityToDto));
    }

    @Cacheable("PRODUCT_CARD_PAGE_CACHE_OPTIONAL")
    public RestPage<ProductCardDto> findAllByCategoryOrOwnerIdPageable(UUID ownerId, Long categoryId, Pageable pageable) {
        return new RestPage<>(repository.findAllByOwnerIdOrCategoryPageable(ownerId, categoryId, pageable).
                map(mapper::entityToDto));
    }

    @Cacheable("PRODUCT_CARD_CACHE")
    public Collection<ProductCardDto> findAllByCategoryOrOwnerId(UUID ownerId, Long categoryId) {
        return repository.findAllByOwnerIdOrCategory(ownerId, categoryId)
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }
}
