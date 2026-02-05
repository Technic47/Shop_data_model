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
    @Cacheable
    public ProductDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @CacheEvict
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @CachePut(key = "#dto.id")
    public ProductDto add(ProductDto dto) {
        return super.add(dto);
    }

    @Override
    @CachePut(key = "#dto.id")
    public ProductDto update(ProductDto dto) {
        return super.update(dto);
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
