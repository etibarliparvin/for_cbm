package az.parvin.hremployeeservice.checker;

import az.parvin.hremployeeservice.myException.BusinessExceptionEnum;
import az.parvin.hremployeeservice.myException.ConflictException;
import az.parvin.hremployeeservice.service.department.DepartmentFunctionalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DepartmentRepetitionChecker {

    private final DepartmentFunctionalService service;

    public void check(String name) {
        log.info("Check if Department has already registered with particular name: {}", name);
        if (service.existsByName(name)) {
            throw new ConflictException(BusinessExceptionEnum.DEPARTMENT_IS_ALREADY_EXISTS, name);
        }
    }
}
