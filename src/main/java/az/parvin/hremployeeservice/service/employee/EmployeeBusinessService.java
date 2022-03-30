package az.parvin.hremployeeservice.service.employee;

import az.parvin.hremployeeservice.dto.request.EmployeeRequest;
import az.parvin.hremployeeservice.myException.common.CommonResponse;

public interface EmployeeBusinessService {

    CommonResponse create(EmployeeRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();

    CommonResponse update(Long id, EmployeeRequest request);

    CommonResponse delete(Long id);
}
