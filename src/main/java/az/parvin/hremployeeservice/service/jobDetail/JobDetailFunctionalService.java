package az.parvin.hremployeeservice.service.jobDetail;

import az.parvin.hremployeeservice.domain.JobDetail;

import java.util.List;

public interface JobDetailFunctionalService {

    JobDetail create(JobDetail jobDetail);

    JobDetail findById(Long id);

    List<JobDetail> findAll();

    JobDetail update(Long id, JobDetail jobDetail);
}
