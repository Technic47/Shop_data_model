package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.ProductMapper;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.repository.ProductRepository;
import ru.kuznetsov.shop.represent.dto.ProductDto;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends AbstractService<Product, ProductDto, ProductRepository, ProductMapper> {

    protected ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Cacheable(value = "PRODUCT_CACHE")
    public ProductDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @CacheEvict(value = "PRODUCT_CACHE")
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public List<ProductDto> findAllByOwnerOrCategoryId(UUID ownerId, Long categoryId) {
        return entityMapper.allEntitiesToDtos(repository.findAllByOwnerIdOrCategory(ownerId, categoryId));
    }
}
