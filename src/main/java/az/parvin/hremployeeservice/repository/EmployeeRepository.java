package az.parvin.hremployeeservice.repository;

import az.parvin.hremployeeservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    Optional<Employee> findEmployeeByIdAndIsActiveTrue(Long id);

    List<Employee> findEmployeesByIsActiveTrue();
}
