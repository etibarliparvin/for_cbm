package az.parvin.hremployeeservice.dto.response;

import az.parvin.hremployeeservice.domain.enums.Gender;
import az.parvin.hremployeeservice.domain.enums.WorkType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {

    Long id;
    String firstName;
    String lastName;
    LocalDate birthday;
    String email;
    Gender gender;
    String phone;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
    Boolean isActive;
    String status; // anlamadim bu hisseni
    WorkType workType;
    AddressResponse address;
    JobDetailResponse jobDetail;
    DepartmentResponse department;
}
