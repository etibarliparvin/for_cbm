package az.parvin.hremployeeservice.service.department;

import az.parvin.hremployeeservice.dto.request.DepartmentRequest;
import az.parvin.hremployeeservice.myException.common.CommonResponse;

public interface DepartmentBusinessService {

    CommonResponse create(DepartmentRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();

    CommonResponse update(Long id, DepartmentRequest request);
}
