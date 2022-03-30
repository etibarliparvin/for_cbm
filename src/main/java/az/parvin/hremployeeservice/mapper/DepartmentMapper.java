package az.parvin.hremployeeservice.mapper;

import az.parvin.hremployeeservice.domain.Department;
import az.parvin.hremployeeservice.dto.request.DepartmentRequest;
import az.parvin.hremployeeservice.dto.response.DepartmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toEntity(DepartmentRequest request);

    DepartmentResponse toResponse(Department department);
}
