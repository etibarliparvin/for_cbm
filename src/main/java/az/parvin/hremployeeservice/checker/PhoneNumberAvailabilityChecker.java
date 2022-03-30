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
public class PhoneNumberAvailabilityChecker {

    private final EmployeeFunctioanlService service;

    public void check(String phone) {
        log.info("Check if employee has already registered with particular number: {}", phone);
        if (service.checkExistsByPhone(phone)) {
            throw new ConflictException(BusinessExceptionEnum.PHONE_NUMBER_IS_ALREADY_EXISTS, phone);
        }
    }
}
