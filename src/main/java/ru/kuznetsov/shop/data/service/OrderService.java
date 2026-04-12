package ru.kuznetsov.shop.data.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.mapper.order.OrderMapper;
import ru.kuznetsov.shop.data.model.order.Order;
import ru.kuznetsov.shop.data.repository.OrderRepository;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;
import ru.kuznetsov.shop.represent.dto.order.OrderThinDto;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@CacheConfig("ORDER_CACHE")
public class OrderService extends AbstractService<Order, OrderDto, OrderRepository, OrderMapper> {
    protected OrderService(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
    }

    public List<OrderDto> getAllByCustomerId(UUID customerId) {
        return entityMapper.allEntitiesToDtos(repository.getAllByCustomerId(customerId));
    }

    /**
     * Метод для поиска заказов с определёнными статусами.
     *
     * @param customerId   - id того пользователя, кто сделал заказ (nullable)
     * @param dateAfter    - фильтровать заказы после этой даты (nullable)
     * @param dateBefore   - фильтровать запозы до этой даты  (nullable)
     * @param hasStatus    - статус должен быть у заказа
     * @param hasNotStatus - статус Не должен быть у заказа
     * @return Список отфильтрованных заказов по статусам и доп параметрам.
     */
    public List<OrderThinDto> getAllByStatusAndOptionalParams(
            UUID customerId,
            LocalDateTime dateAfter,
            LocalDateTime dateBefore,
            OrderStatusType hasStatus,
            OrderStatusType hasNotStatus
    ) {
        return repository.getAllByHavingStatusAndNotHavingOther(
                        customerId,
                        dateAfter,
                        dateBefore,
                        hasStatus,
                        hasNotStatus
                ).parallelStream()
                .map(entityMapper::entityToThinDto)
                .toList();
    }
}
