package ru.kuznetsov.shop.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.shop.data.model.parameter.Parameter;

import java.util.Optional;

@Repository
public interface ParameterRepository extends CrudRepository<Parameter, Long> {

    Optional<Parameter> findByKey(String key);

    Optional<Parameter> findByValue(String value);
}
