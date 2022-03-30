package az.parvin.hremployeeservice.mapper;

import az.parvin.hremployeeservice.domain.JobDetail;
import az.parvin.hremployeeservice.dto.request.JobDetailRequest;
import az.parvin.hremployeeservice.dto.response.JobDetailResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobDetailMapper {

    JobDetail toEntity(JobDetailRequest request);

    JobDetailResponse toResponse(JobDetail jobDetail);
}
