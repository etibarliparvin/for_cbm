package az.parvin.hremployeeservice.service.employee;

import az.parvin.hremployeeservice.checker.DepartmentRepetitionChecker;
import az.parvin.hremployeeservice.checker.EmailAvailabilityChecker;
import az.parvin.hremployeeservice.checker.PhoneNumberAvailabilityChecker;
import az.parvin.hremployeeservice.domain.Employee;
import az.parvin.hremployeeservice.dto.request.EmployeeRequest;
import az.parvin.hremployeeservice.mapper.EmployeeMapper;
import az.parvin.hremployeeservice.myException.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeBusinessServiceImpl implements EmployeeBusinessService {

    private final EmployeeFunctioanlService employeeService;

    private final EmailAvailabilityChecker emailChecker;
    private final PhoneNumberAvailabilityChecker phoneChecker;
    private final DepartmentRepetitionChecker departmentChecker;

    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional
    public CommonResponse create(EmployeeRequest request) {
        phoneChecker.check(request.getPhone());

        if (request.getEmail() != null)
            emailChecker.check(request.getEmail());

        departmentChecker.check(request.getDepartment().getDepartmentName());

        CommonResponse response = new CommonResponse();
        Employee employee = employeeMapper.toEntity(request);
        employee.getAddress().setEmployee(employee);
        employee.getJobDetail().setEmployee(employee);
        employee = employeeService.create(employee);

        response.setItem(employeeMapper.toResponse(employee));
        return response;
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        response.setItem(employeeMapper.toResponse(employeeService.findActiveById(id)));
        return response;
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        List<Employee> list = employeeService.findActiveEmployees();
        response.setItem(list.stream().map(employeeMapper::toResponse).collect(Collectors.toList()));
        return response;
    }

    @Override
    public CommonResponse update(Long id, EmployeeRequest request) {
        CommonResponse response = new CommonResponse();
        Employee employee = employeeMapper.toEntity(request);
        response.setItem(employeeMapper.toResponse(employeeService.update(id, employee)));
        return response;
    }

    @Override
    public CommonResponse delete(Long id) {
        CommonResponse response = new CommonResponse();
        response.setItem(employeeService.delete(id));
        return response;
    }
}
