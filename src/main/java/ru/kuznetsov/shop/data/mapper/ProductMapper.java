package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.model.ProductCategory;
import ru.kuznetsov.shop.data.service.ProductCategoryService;
import ru.kuznetsov.shop.represent.dto.ProductDto;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements AbstractMapper<Product, ProductDto> {
    @Autowired
    protected ProductCategoryService productCategoryService;

    @Override
    @Mapping(target = "category", source = "entity.category.name")
    @Mapping(target = "ownerId", source = "owner", qualifiedByName = "UUIDToString")
    public abstract ProductDto entityToDto(Product entity);

    @Override
    @Mapping(target = "category", source = "category", qualifiedByName = "nameToEntity")
    @Mapping(target = "owner", source = "ownerId", qualifiedByName = "stringToUUID")
    public abstract Product dtoToEntity(ProductDto dto);

    @Named("nameToEntity")
    protected ProductCategory entityToEntity(String name) {
        return productCategoryService.findEntityByName(name);
    }

    @Named("UUIDToString")
    protected String UUIDToString(UUID uuid) {
        return uuid.toString();
    }

    @Named("stringToUUID")
    protected UUID stringToUUID(String uuidString) {
        return UUID.fromString(uuidString);
    }
}
