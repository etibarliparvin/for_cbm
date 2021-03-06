package az.parvin.hremployeeservice.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentRequest {

    String departmentName;
    String departmentDirector;
}
