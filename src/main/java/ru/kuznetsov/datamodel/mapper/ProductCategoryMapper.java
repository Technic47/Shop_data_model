package ru.kuznetsov.datamodel.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.datamodel.dto.ProductCategoryDto;
import ru.kuznetsov.datamodel.model.ProductCategory;

@Mapper(componentModel = "spring")
public abstract class ProductCategoryMapper implements AbstractMapper<ProductCategory, ProductCategoryDto> {
}
