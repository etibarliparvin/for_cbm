package az.parvin.hremployeeservice.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobDetailRequest {

    LocalDate startDate;
    LocalDate endDate;
    BigDecimal currentSalary;
    BigDecimal lastSalary;
}
