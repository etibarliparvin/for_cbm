package az.parvin.hremployeeservice.myException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public enum BusinessExceptionEnum {

    EMPLOYEE_BY_ID_NOT_FOUND("Employee by id: %s not found",
            "404",
            "the employee not found in our database"),
    EMPLOYEE_BY_ID_NOT_ACTIVE("Employee by id: %s not active",
            "404",
            "the employee is not active"),
    EMPLOYEE_NOT_FOUND("Employee not found",
            "404",
            "the employee not found in our database"),
    EMPLOYEE_LIST_IS_EMPTY("Employees are not found",
            "404",
            "the employees not found in our database"),
    ADDRESS_BY_ID_NOT_FOUND("Address by id: %s not found",
            "404",
            "the address not found in our database"),
    ADDRESS_LIST_IS_EMPTY("Addresses are not found",
            "404",
            "the addresses not found in our database"),
    JOB_DETAIL_BY_ID_NOT_FOUND("Job detail by id: %s not found",
            "404",
            "the job detail not found in our database"),
    JOB_DETAIL_LIST_IS_EMPTY("Job detail list is empty",
            "404",
            "the job details not found in our database"),
    DEPARTMENT_BY_ID_NOT_FOUND("Department by id: %s not found",
            "404",
            "the department not found in our database"),
    DEPARTMENT_NAME_ID_NOT_FOUND("Department by name: %s not found",
            "404",
            "the department not found in our database"),
    DEPARTMENT_LIST_IS_EMPTY("Departments are not found",
            "404",
            "the departments not found in our database"),
    EMPLOYEE_IS_NOT_ACTIVE_FOR_UPDATE("Employee is not active for update",
            "500",
            "Employee is not active for update"),
    UPLOAD_IMAGE_ERROR("Error occured while upload image",
            "500",
            "Error occurred while upload image"),
    DATE_TIME_FORMAT_ERROR("Date Time pattern is not valid",
            "404",
            "Date Time pattern (yyyy-MM-dd hh:mm:ss) is not valid"),
    DATE_FORMAT_ERROR("Date pattern(yyyy-MM-dd) is not valid",
            "404",
            "Date pattern(yyyy-MM-dd) is not valid"),
    PHONE_NUMBER_IS_ALREADY_EXISTS("%s phone number is already exists",
            "500",
            "This particular phone number is already exists in our database"),
    EMAIL_IS_ALREADY_EXISTS("%s email is already exists",
            "500",
            "This particular email address is already exists in our database"),
    DEPARTMENT_IS_ALREADY_EXISTS("Department %s is already exists",
            "500",
            "This particular Department is already exists in our database");

    String message;
    String code;
    String description;
}
