package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.order.BucketItemMapper;
import ru.kuznetsov.shop.data.model.order.BucketItem;
import ru.kuznetsov.shop.data.repository.BucketItemRepository;
import ru.kuznetsov.shop.represent.dto.order.BucketItemDto;

@Service
public class BucketItemService extends AbstractService<BucketItem, BucketItemDto, BucketItemRepository, BucketItemMapper> {

    protected BucketItemService(BucketItemRepository repository, BucketItemMapper mapper) {
        super(repository, mapper);
    }
}
