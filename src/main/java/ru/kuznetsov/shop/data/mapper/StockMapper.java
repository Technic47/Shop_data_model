package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.data.dto.StockDto;
import ru.kuznetsov.shop.data.model.Address;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.model.Stock;
import ru.kuznetsov.shop.data.model.Store;
import ru.kuznetsov.shop.data.service.ProductService;
import ru.kuznetsov.shop.data.service.StoreService;

@Mapper(componentModel = "spring")
public abstract class StockMapper implements AbstractMapper<Stock, StockDto> {
    @Autowired
    protected StoreService storeService;
    @Autowired
    protected ProductService productService;

    @Override
    @Mapping(target = "productId", source = "entity.product.id")
    @Mapping(target = "productName", source = "entity.product.name")
    @Mapping(target = "store", source = "entity.store.name")
    @Mapping(target = "storeAddress", source = "entity.store.address", qualifiedByName = "getAddressString")
    public abstract StockDto entityToDto(Stock entity);

    @Override
    @Mapping(target = "store", source = "store", qualifiedByName = "storeNameToEntity")
    @Mapping(target = "product", source = "productId", qualifiedByName = "idToProduct")
    public abstract Stock dtoToEntity(StockDto dto);

    @Named("getAddressString")
    protected String getAddressString(Address address) {
        return address.getAddressString();
    }

    @Named("storeNameToEntity")
    protected Store storeNameToEntity(String name) {
        return storeService.findEntityByName(name);
    }

    @Named("idToProduct")
    protected Product idToProduct(Long name) {
        return productService.findEntityById(name);
    }
}
