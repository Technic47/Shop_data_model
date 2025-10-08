package ru.kuznetsov.datamodel.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.kuznetsov.datamodel.dto.ProductDto;
import ru.kuznetsov.datamodel.mapper.ProductMapper;
import ru.kuznetsov.datamodel.model.Product;
import ru.kuznetsov.datamodel.repository.ProductRepository;

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
