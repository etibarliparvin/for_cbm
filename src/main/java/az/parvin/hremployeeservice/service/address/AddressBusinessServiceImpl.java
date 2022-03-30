package az.parvin.hremployeeservice.service.address;

import az.parvin.hremployeeservice.domain.Address;
import az.parvin.hremployeeservice.dto.request.AddressRequest;
import az.parvin.hremployeeservice.mapper.AddressMapper;
import az.parvin.hremployeeservice.myException.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressBusinessServiceImpl implements AddressBusinessService {

    private final AddressFunctionalService service;
    private final AddressMapper mapper;

    @Override
    public CommonResponse create(AddressRequest request) {
        CommonResponse response = new CommonResponse();
        Address address = mapper.toEntity(request);
        response.setItem(mapper.toResponse(service.create(address)));
        return response;
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        response.setItem(mapper.toResponse(service.findById(id)));
        return response;
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        response.setItem(service.findAll().stream().map(mapper::toResponse).collect(Collectors.toList()));
        return response;
    }

    @Override
    public CommonResponse update(Long id, AddressRequest request) {
        CommonResponse response = new CommonResponse();
        Address address = mapper.toEntity(request);
        response.setItem(mapper.toResponse(service.update(id, address)));
        return response;
    }
}
