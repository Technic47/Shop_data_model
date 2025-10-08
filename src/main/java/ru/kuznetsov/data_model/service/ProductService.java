package ru.kuznetsov.data_model.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.data_model.dto.ProductDto;
import ru.kuznetsov.data_model.mapper.ProductMapper;
import ru.kuznetsov.data_model.model.Product;
import ru.kuznetsov.data_model.repository.ProductRepository;

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
}
