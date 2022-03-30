package az.parvin.hremployeeservice.service.employee;

import az.parvin.hremployeeservice.domain.Employee;
import az.parvin.hremployeeservice.mapper.EmployeeMapper;
import az.parvin.hremployeeservice.myException.BusinessExceptionEnum;
import az.parvin.hremployeeservice.myException.NotFoundException;
import az.parvin.hremployeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeFunctionalServiceImpl implements EmployeeFunctioanlService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> found = employeeRepository.findAll();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_LIST_IS_EMPTY);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Optional<Employee> found = employeeRepository.findById(id);
        if (found.isPresent()) {
            employee.setId(id);
            employee.setCreatedAt(found.get().getCreatedAt());
            return employeeRepository.save(employee);
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Employee> found = employeeRepository.findById(id);
        if (found.isPresent()) {
            found.get().setIsActive(Boolean.FALSE);
            employeeRepository.save(found.get());
            return true;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public boolean checkExistsByPhone(String phone) {
        return employeeRepository.existsByPhone(phone);
    }

    @Override
    public boolean checkExistsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public Employee findActiveById(Long id) {
        Optional<Employee> found = employeeRepository.findEmployeeByIdAndIsActiveTrue(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<Employee> findActiveEmployees() {
        List<Employee> list = employeeRepository.findEmployeesByIsActiveTrue();
        if (!list.isEmpty()) {
            return list;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_LIST_IS_EMPTY);
    }
}
