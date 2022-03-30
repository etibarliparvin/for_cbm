package az.parvin.hremployeeservice.service.address;

import az.parvin.hremployeeservice.dto.request.AddressRequest;
import az.parvin.hremployeeservice.myException.common.CommonResponse;

public interface AddressBusinessService {

    CommonResponse create(AddressRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();

    CommonResponse update(Long id, AddressRequest request);
}
