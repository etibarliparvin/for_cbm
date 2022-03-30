package az.parvin.hremployeeservice.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentResponse {

    Long id;
    String departmentName;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
    String departmentDirector;
}
