package az.parvin.hremployeeservice.mapper;

import az.parvin.hremployeeservice.domain.Employee;
import az.parvin.hremployeeservice.dto.request.EmployeeRequest;
import az.parvin.hremployeeservice.dto.response.EmployeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequest request);

    EmployeeResponse toResponse(Employee employee);
}
