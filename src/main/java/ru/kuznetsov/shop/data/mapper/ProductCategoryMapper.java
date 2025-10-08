package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.shop.data.dto.ProductCategoryDto;
import ru.kuznetsov.shop.data.model.ProductCategory;

@Mapper(componentModel = "spring")
public abstract class ProductCategoryMapper implements AbstractMapper<ProductCategory, ProductCategoryDto> {
}
