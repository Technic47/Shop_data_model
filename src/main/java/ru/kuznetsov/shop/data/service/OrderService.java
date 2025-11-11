package ru.kuznetsov.shop.data.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.order.OrderMapper;
import ru.kuznetsov.shop.data.model.order.Order;
import ru.kuznetsov.shop.data.repository.OrderRepository;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends AbstractService<Order, OrderDto, OrderRepository, OrderMapper> {
    protected OrderService(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
    }

    public List<OrderDto> getAllByCustomerId(UUID customerId) {
        return entityMapper.allEntitiesToDtos(repository.getAllByCustomerId(customerId));
    }
}
