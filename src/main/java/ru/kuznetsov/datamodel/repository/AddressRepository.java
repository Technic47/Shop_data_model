package ru.kuznetsov.datamodel.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.datamodel.model.Address;

@Repository
public interface AddressRepository extends AbstractRepository<Address> {
}
