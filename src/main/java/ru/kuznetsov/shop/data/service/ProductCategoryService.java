package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.ProductCategoryMapper;
import ru.kuznetsov.shop.data.model.ProductCategory;
import ru.kuznetsov.shop.data.repository.ProductCategoryRepository;
import ru.kuznetsov.shop.represent.dto.ProductCategoryDto;

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
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'ALL_VALUES'")
            }
    )
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'")
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public ProductCategoryDto add(ProductCategoryDto dto) {
        return super.add(dto);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(key = "'ALL_VALUES'")
            },
            put = {
                    @CachePut(key = "#result.id")
            }
    )
    public ProductCategoryDto update(ProductCategoryDto dto) {
        return super.update(dto);
    }

    @Override
    @Cacheable(key = "'ALL_VALUES'")
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
