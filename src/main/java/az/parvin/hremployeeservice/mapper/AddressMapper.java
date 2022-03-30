package az.parvin.hremployeeservice.mapper;

import az.parvin.hremployeeservice.domain.Address;
import az.parvin.hremployeeservice.dto.request.AddressRequest;
import az.parvin.hremployeeservice.dto.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressRequest request);

    AddressResponse toResponse(Address address);
}
