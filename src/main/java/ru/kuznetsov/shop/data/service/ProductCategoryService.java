package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.represent.dto.ProductCategoryDto;
import ru.kuznetsov.shop.data.mapper.ProductCategoryMapper;
import ru.kuznetsov.shop.data.model.ProductCategory;
import ru.kuznetsov.shop.data.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService extends AbstractService<ProductCategory, ProductCategoryDto, ProductCategoryRepository, ProductCategoryMapper> {
    protected ProductCategoryService(ProductCategoryRepository repository, ProductCategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    @Cacheable(value = "PRODUCT_CATEGORY_CACHE")
    public ProductCategoryDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    @CacheEvict(value = "PRODUCT_CATEGORY_CACHE")
    public void deleteById(Long id) {
        super.deleteById(id);
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
