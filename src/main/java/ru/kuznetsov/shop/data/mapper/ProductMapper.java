package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.data.mapper.util.UUIDToStringConverter;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.model.ProductCategory;
import ru.kuznetsov.shop.data.service.ProductCategoryService;
import ru.kuznetsov.shop.represent.dto.ProductDto;

@Mapper(componentModel = "spring", uses = {UUIDToStringConverter.class})
public abstract class ProductMapper implements AbstractMapper<Product, ProductDto> {
    @Autowired
    protected ProductCategoryService productCategoryService;

    @Override
    @Mapping(target = "category", source = "entity.category.name")
    @Mapping(target = "ownerId", source = "owner")
    public abstract ProductDto entityToDto(Product entity);

    @Override
    @Mapping(target = "category", source = "category", qualifiedByName = "nameToEntity")
    @Mapping(target = "owner", source = "ownerId")
    public abstract Product dtoToEntity(ProductDto dto);

    @Named("nameToEntity")
    public ProductCategory entityToEntity(String name) {
        return productCategoryService.findEntityByName(name);
    }
}
