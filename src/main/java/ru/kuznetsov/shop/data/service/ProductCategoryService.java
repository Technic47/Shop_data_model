package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.ProductCategoryDto;
import ru.kuznetsov.shop.data.mapper.ProductCategoryMapper;
import ru.kuznetsov.shop.data.model.ProductCategory;
import ru.kuznetsov.shop.data.repository.ProductCategoryRepository;

import java.util.List;

@Service
@CacheConfig("PRODUCT_CATEGORY_CACHE")
public class ProductCategoryService extends AbstractService<ProductCategory, ProductCategoryDto, ProductCategoryRepository, ProductCategoryMapper> {
    protected ProductCategoryService(ProductCategoryRepository repository, ProductCategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Cacheable
    public ProductCategoryDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @CacheEvict
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @CachePut(key = "#dto.id")
    public ProductCategoryDto add(ProductCategoryDto dto) {
        return super.add(dto);
    }

    @Override
    @CachePut(key = "#dto.id")
    public ProductCategoryDto update(ProductCategoryDto dto) {
        return super.update(dto);
    }

    @Override
    @Cacheable
    public List<ProductCategoryDto> findAll() {
        return super.findAll();
    }

    public ProductCategory findEntityByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }

    public ProductCategoryDto findByName(String name) {
        return entityMapper.entityToDto(findEntityByName(name));
    }
}
