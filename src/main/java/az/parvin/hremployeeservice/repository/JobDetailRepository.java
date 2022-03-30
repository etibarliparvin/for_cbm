package az.parvin.hremployeeservice.repository;

import az.parvin.hremployeeservice.domain.JobDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDetailRepository extends JpaRepository<JobDetail, Long> {
}
