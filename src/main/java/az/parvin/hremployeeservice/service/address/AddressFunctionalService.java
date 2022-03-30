package az.parvin.hremployeeservice.service.address;

import az.parvin.hremployeeservice.domain.Address;

import java.util.List;

public interface AddressFunctionalService {

    Address create(Address address);

    Address findById(Long id);

    List<Address> findAll();

    Address update(Long id, Address address);
}
