package ru.kuznetsov.shop.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.data.model.parameter.Parameter;
import ru.kuznetsov.shop.data.repository.ParameterRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParameterService {

    private final ParameterRepository parameterRepository;

    public Iterable<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    public Optional<Parameter> findById(Long id) {
        return parameterRepository.findById(id);
    }

    public Optional<Parameter> findByKey(String key) {
        return parameterRepository.findByKey(key);
    }

    public Optional<Parameter> findByValue(String value) {
        return parameterRepository.findByValue(value);
    }

    public Parameter save(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public void deleteById(Long id) {
        parameterRepository.deleteById(id);
    }

    public String getParameterValueString(String key){
        return getParameterValue(key);
    }

    public Long getParameterValueLong(String key){
        String parameterValue = getParameterValue(key);
        try {
            return Long.parseLong(parameterValue);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Parameter value parsing error. " + e.getMessage());
        }
    }

    private String getParameterValue(String key){
        return findByKey(key).orElseThrow(() -> new RuntimeException("Parameter with key " + key + " not found")).getValue();
    }
}
