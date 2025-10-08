package ru.kuznetsov.data_model.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.data_model.model.Address;

@Repository
public interface AddressRepository extends AbstractRepository<Address> {
}
