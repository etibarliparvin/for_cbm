package az.parvin.hremployeeservice.domain;

import az.parvin.hremployeeservice.domain.enums.Gender;
import az.parvin.hremployeeservice.domain.enums.WorkType;
import az.parvin.hremployeeservice.validation.email.Email;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    LocalDate birthday;
    @Email
    @Column(nullable = false, unique = true)
    String email;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Column(nullable = false)
    String phone;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime modifiedAt;
    @Column(columnDefinition = "Boolean default true") // bu iwlemedi
    Boolean isActive = true;
    String status; // anlamadim bu hisseni
    @Enumerated(EnumType.STRING)
    WorkType workType;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    Address address;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    JobDetail jobDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    Department department;
}
