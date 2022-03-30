package az.parvin.hremployeeservice.dto.request;

import az.parvin.hremployeeservice.domain.enums.Gender;
import az.parvin.hremployeeservice.domain.enums.WorkType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {

    String firstName;
    String lastName;
    LocalDate birthday;
    String email;
    Gender gender;
    String phone;
    String status;
    WorkType workType;
    AddressRequest address;
    JobDetailRequest jobDetail;
    DepartmentRequest department;
}
