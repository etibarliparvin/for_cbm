package az.parvin.hremployeeservice.service.department;

import az.parvin.hremployeeservice.domain.Department;
import az.parvin.hremployeeservice.myException.BusinessExceptionEnum;
import az.parvin.hremployeeservice.myException.NotFoundException;
import az.parvin.hremployeeservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentFunctionalServiceImpl implements DepartmentFunctionalService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findById(Long id) {
        Optional<Department> found = departmentRepository.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<Department> findAll() {
        List<Department> found = departmentRepository.findAll();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_LIST_IS_EMPTY);
    }

    @Override
    public Department update(Long id, Department department) {
        Optional<Department> found = departmentRepository.findById(id);
        if (found.isPresent()) {
            department.setId(id);
            department.setCreatedAt(found.get().getCreatedAt());
            return departmentRepository.save(department);
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, id);
    }

    @Override
    public boolean existsByName(String name) {
        return departmentRepository.existsByDepartmentName(name);
    }
}
