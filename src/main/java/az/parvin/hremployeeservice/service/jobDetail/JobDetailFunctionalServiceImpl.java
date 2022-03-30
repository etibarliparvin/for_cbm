package az.parvin.hremployeeservice.service.jobDetail;

import az.parvin.hremployeeservice.domain.JobDetail;
import az.parvin.hremployeeservice.myException.BusinessExceptionEnum;
import az.parvin.hremployeeservice.myException.NotFoundException;
import az.parvin.hremployeeservice.repository.JobDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobDetailFunctionalServiceImpl implements JobDetailFunctionalService {

    private final JobDetailRepository repository;

    @Override
    public JobDetail create(JobDetail jobDetail) {
        return repository.save(jobDetail);
    }

    @Override
    public JobDetail findById(Long id) {
        Optional<JobDetail> found = repository.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        throw new NotFoundException(BusinessExceptionEnum.JOB_DETAIL_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<JobDetail> findAll() {
        List<JobDetail> found = repository.findAll();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NotFoundException(BusinessExceptionEnum.JOB_DETAIL_LIST_IS_EMPTY);
    }

    @Override
    public JobDetail update(Long id, JobDetail jobDetail) {
        Optional<JobDetail> found = repository.findById(id);
        if (found.isPresent()) {
            jobDetail.setId(id);
            jobDetail.setCreatedAt(found.get().getCreatedAt());
            return repository.save(jobDetail);
        }
        throw new NotFoundException(BusinessExceptionEnum.JOB_DETAIL_BY_ID_NOT_FOUND, id);
    }
}
