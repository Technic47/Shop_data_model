package ru.kuznetsov.data_model.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.data_model.dto.ProductCategoryDto;
import ru.kuznetsov.data_model.mapper.ProductCategoryMapper;
import ru.kuznetsov.data_model.model.ProductCategory;
import ru.kuznetsov.data_model.repository.ProductCategoryRepository;

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

    public ProductCategory findByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(RuntimeException::new);
    }
}
