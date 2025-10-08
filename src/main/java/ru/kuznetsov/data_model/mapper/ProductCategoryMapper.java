package ru.kuznetsov.data_model.mapper;

import org.mapstruct.Mapper;
import ru.kuznetsov.data_model.dto.ProductCategoryDto;
import ru.kuznetsov.data_model.model.ProductCategory;

@Mapper(componentModel = "spring")
public abstract class ProductCategoryMapper implements AbstractMapper<ProductCategory, ProductCategoryDto> {
}
