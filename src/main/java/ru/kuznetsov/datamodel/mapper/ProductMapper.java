package ru.kuznetsov.datamodel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.datamodel.dto.ProductDto;
import ru.kuznetsov.datamodel.model.Product;
import ru.kuznetsov.datamodel.model.ProductCategory;
import ru.kuznetsov.datamodel.service.ProductCategoryService;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements AbstractMapper<Product, ProductDto> {
    @Autowired
    protected ProductCategoryService productCategoryService;

    @Override
    @Mapping(target = "category", source = "entity.category.name")
    public abstract ProductDto entityToDto(Product entity);

    @Override
    @Mapping(target = "category", source = "category", qualifiedByName = "nameToEntity")
    public abstract Product dtoToEntity(ProductDto dto);

    @Named("nameToEntity")
    protected ProductCategory entityToEntity(String name) {
        return productCategoryService.findByName(name);
    }
}
