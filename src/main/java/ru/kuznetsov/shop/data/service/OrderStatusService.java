package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.order.OrderStatusMapper;
import ru.kuznetsov.shop.data.model.order.OrderStatus;
import ru.kuznetsov.shop.data.repository.OrderStatusRepository;
import ru.kuznetsov.shop.represent.dto.order.OrderStatusDto;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@CacheConfig("ORDER_STATUS_CACHE")
public class OrderStatusService extends AbstractService<OrderStatus, OrderStatusDto, OrderStatusRepository, OrderStatusMapper> {
    protected OrderStatusService(OrderStatusRepository repository, OrderStatusMapper mapper) {
        super(repository, mapper);
    }

    public List<OrderStatusDto> getAllByOrderId(Long orderId) {
        return entityMapper.allEntitiesToDtos(repository.getAllByOrderId(orderId));
    }

    public OrderStatusDto getLastByOrderId(Long orderId) {
        return getAllByOrderId(orderId).stream()
                .filter(status -> status.getCreated() != null)
                .sorted(Comparator.comparing(OrderStatusDto::getCreated).reversed())
                .toList()
                .get(0);
    }

    public List<OrderStatusDto> getAllByStatus(OrderStatusType status) {
        return entityMapper.allEntitiesToDtos(repository.getAllByStatus(status));
    }

    public List<OrderStatusDto> getAllByStatusAfter(OrderStatusType status, LocalDateTime dateTimeAfter) {
        return entityMapper.allEntitiesToDtos(repository.getAllByStatusAndCreatedAfter(status, dateTimeAfter));
    }

    public List<OrderStatusDto> getAllByStatusBefore(OrderStatusType status, LocalDateTime dateTimeBefore) {
        return entityMapper.allEntitiesToDtos(repository.getAllByStatusAndCreatedBefore(status, dateTimeBefore));
    }
}
