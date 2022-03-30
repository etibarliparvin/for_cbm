package az.parvin.hremployeeservice.checker;

import az.parvin.hremployeeservice.myException.BusinessExceptionEnum;
import az.parvin.hremployeeservice.myException.ConflictException;
import az.parvin.hremployeeservice.service.employee.EmployeeFunctioanlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailAvailabilityChecker {

    private final EmployeeFunctioanlService service;

    public void check(String email) {
        log.info("Check if employee has already registered with particular email: {}", email);
        if (service.checkExistsByEmail(email)) {
            throw new ConflictException(BusinessExceptionEnum.PHONE_NUMBER_IS_ALREADY_EXISTS, email);
        }
    }
}
