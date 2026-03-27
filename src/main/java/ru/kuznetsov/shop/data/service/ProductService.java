package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.ProductMapper;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.repository.ProductRepository;
import ru.kuznetsov.shop.represent.dto.ProductDto;

import java.util.List;
import java.util.UUID;

@Service
@CacheConfig("PRODUCT_CACHE")
public class ProductService extends AbstractService<Product, ProductDto, ProductRepository, ProductMapper> {

    protected ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Cacheable(unless="#result == null")
    public ProductDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "PRODUCT_CARD_CACHE", allEntries = true),
                    @CacheEvict(value = "PRODUCT_CARD_PAGE_CACHE", allEntries = true),
                    @CacheEvict(value = "PRODUCT_CARD_PAGE_CACHE_OPTIONAL", allEntries = true),
                    @CacheEvict(value = "STOCK_OPTIONAL_PARAMS", allEntries = true)
            }
    )
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "PRODUCT_CARD_CACHE", allEntries = true),
                    @CacheEvict(value = "PRODUCT_CARD_PAGE_CACHE", allEntries = true),
                    @CacheEvict(value = "PRODUCT_CARD_PAGE_CACHE_OPTIONAL", allEntries = true)
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public ProductDto add(ProductDto dto) {
        return super.add(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'"),
                    @CacheEvict(value = "PRODUCT_CARD_CACHE", allEntries = true),
                    @CacheEvict(value = "PRODUCT_CARD_PAGE_CACHE", allEntries = true),
                    @CacheEvict(value = "PRODUCT_CARD_PAGE_CACHE_OPTIONAL", allEntries = true)
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public ProductDto update(ProductDto dto) {
        return super.update(dto);
    }

    @Override
    @Cacheable(key = "'ALL_VALUES'")
    public List<ProductDto> findAll() {
        return super.findAll();
    }

    @Cacheable
    public List<ProductDto> findAllByOwnerOrCategoryId(UUID ownerId, Long categoryId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOwnerIdOrCategory(ownerId, categoryId));
    }

    public String getOwner(Long id) {
        if (repository.existsById(id)) {
            return repository.getOwnerId(id);
        } else throw new RuntimeException(String.format("Product с id=%s не существует", id));
    }
}
