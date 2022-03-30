package az.parvin.hremployeeservice.service.jobDetail;

import az.parvin.hremployeeservice.dto.request.JobDetailRequest;
import az.parvin.hremployeeservice.myException.common.CommonResponse;

public interface JobDetailBusinessService {

    CommonResponse create(JobDetailRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();

    CommonResponse update(Long id, JobDetailRequest request);
}
