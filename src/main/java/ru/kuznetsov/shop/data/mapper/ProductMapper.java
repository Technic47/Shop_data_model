package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.model.ProductCategory;
import ru.kuznetsov.shop.data.service.ProductCategoryService;
import ru.kuznetsov.shop.represent.dto.ProductDto;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements AbstractMapper<Product, ProductDto> {
    @Autowired
    protected ProductCategoryService productCategoryService;

    @Override
    @Mapping(target = "category", source = "entity.category.name")
    @Mapping(target = "ownerId", expression = "java(entity.getOwner().toString())")
    public abstract ProductDto entityToDto(Product entity);

    @Override
    @Mapping(target = "category", source = "category", qualifiedByName = "nameToEntity")
    @Mapping(target = "owner", expression = "java(UUID.fromString(dto.getOwnerId()))")
    public abstract Product dtoToEntity(ProductDto dto);

    @Named("nameToEntity")
    protected ProductCategory entityToEntity(String name) {
        return productCategoryService.findEntityByName(name);
    }
}
