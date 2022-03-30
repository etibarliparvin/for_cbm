package az.parvin.hremployeeservice.service.jobDetail;

import az.parvin.hremployeeservice.domain.JobDetail;
import az.parvin.hremployeeservice.dto.request.JobDetailRequest;
import az.parvin.hremployeeservice.mapper.JobDetailMapper;
import az.parvin.hremployeeservice.myException.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobDetailBusinessServiceImpl implements JobDetailBusinessService {

    private final JobDetailFunctionalService service;
    private final JobDetailMapper mapper;

    @Override
    public CommonResponse create(JobDetailRequest request) {
        CommonResponse response = new CommonResponse();
        JobDetail jobDetail = mapper.toEntity(request);
        response.setItem(mapper.toResponse(service.create(jobDetail)));
        return response;
    }

    @Override
    public CommonResponse findById(Long id) {
        CommonResponse response = new CommonResponse();
        response.setItem(mapper.toResponse(service.findById(id)));
        return response;
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse response = new CommonResponse();
        response.setItem(service.findAll().stream().map(mapper::toResponse).collect(Collectors.toList()));
        return response;
    }

    @Override
    public CommonResponse update(Long id, JobDetailRequest request) {
        CommonResponse response = new CommonResponse();
        JobDetail jobDetail = mapper.toEntity(request);
        response.setItem(mapper.toResponse(service.update(id, jobDetail)));
        return response;
    }
}
