package az.parvin.hremployeeservice.service.employee;

import az.parvin.hremployeeservice.domain.Employee;

import java.util.List;

public interface EmployeeFunctioanlService {

    Employee create(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    Employee update(Long id, Employee request);

    boolean delete(Long id);

    boolean checkExistsByPhone(String phone);

    boolean checkExistsByEmail(String email);

    Employee findActiveById(Long id);

    List<Employee> findActiveEmployees();
}
