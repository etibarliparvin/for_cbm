package az.parvin.hremployeeservice.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_details")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal currentSalary;
    BigDecimal lastSalary;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime modifiedAt;

    @OneToOne
    @JoinColumn(name = "employee_id")
    Employee employee;
}
