package az.parvin.hremployeeservice.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobDetailResponse {

    Long id;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal currentSalary;
    BigDecimal lastSalary;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
}
