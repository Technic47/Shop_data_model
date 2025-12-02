package ru.kuznetsov.shop.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kuznetsov.shop.data.mapper.util.UUIDToStringConverter;
import ru.kuznetsov.shop.data.model.Product;
import ru.kuznetsov.shop.data.service.StockService;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;
import ru.kuznetsov.shop.represent.dto.StockDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", uses = {UUIDToStringConverter.class})
public abstract class ProductCardMapper {
    @Autowired
    protected StockService stockService;

    @Mapping(target = "ownerId", source = "owner")
    @Mapping(target = "category", source = "category.name")
    @Mapping(target = "stock", source = ".", qualifiedByName = "mapStock")
    public abstract ProductCardDto entityToDto(Product entity);

    public abstract List<ProductCardDto> allEntitiesToDtos(List<Product> entities);

    @Named("mapStock")
    public Map<String, Integer> mapStock(Product product) {
        Map<String, Integer> stockMap = new HashMap<>();

        List<StockDto> stockDtoList = stockService.findAllByOptionalParams(product.getId(), null, product.getOwner()).stream()
                .filter(stock -> stock.getIsReserved() == null || !stock.getIsReserved())
                .toList();

        for (StockDto stockDto : stockDtoList) {
            Integer amount = stockDto.getAmount() == null ? 0 : stockDto.getAmount();

            if (stockMap.containsKey(stockDto.getStore())) {
                Integer currentStock = stockMap.get(stockDto.getStore()) == null ? 0 : stockMap.get(stockDto.getStore());
                stockMap.put(stockDto.getStore(), amount + currentStock);
            } else {
                stockMap.put(stockDto.getStore(), amount);
            }
        }

        return stockMap;
    }
}
