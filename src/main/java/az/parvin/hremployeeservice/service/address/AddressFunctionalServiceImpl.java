package az.parvin.hremployeeservice.service.address;

import az.parvin.hremployeeservice.domain.Address;
import az.parvin.hremployeeservice.myException.BusinessExceptionEnum;
import az.parvin.hremployeeservice.myException.NotFoundException;
import az.parvin.hremployeeservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressFunctionalServiceImpl implements AddressFunctionalService {

    private final AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> found = addressRepository.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<Address> findAll() {
        List<Address> found = addressRepository.findAll();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_LIST_IS_EMPTY);
    }

    @Override
    public Address update(Long id, Address address) {
        Optional<Address> found = addressRepository.findById(id);
        if (found.isPresent()) {
            address.setId(id);
            address.setCreatedAt(found.get().getCreatedAt());
            return addressRepository.save(address);
        }
        throw new NotFoundException(BusinessExceptionEnum.ADDRESS_BY_ID_NOT_FOUND, id);
    }
}
