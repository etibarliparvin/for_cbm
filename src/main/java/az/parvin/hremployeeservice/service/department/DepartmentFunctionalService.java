package az.parvin.hremployeeservice.service.department;

import az.parvin.hremployeeservice.domain.Department;

import java.util.List;

public interface DepartmentFunctionalService {

    Department create(Department department);

    Department findById(Long id);

    List<Department> findAll();

    Department update(Long id, Department department);

    boolean existsByName(String name);
}
