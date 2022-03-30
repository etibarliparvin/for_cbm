package az.parvin.hremployeeservice.service.department;

import az.parvin.hremployeeservice.checker.DepartmentRepetitionChecker;
import az.parvin.hremployeeservice.domain.Department;
import az.parvin.hremployeeservice.dto.request.DepartmentRequest;
import az.parvin.hremployeeservice.mapper.DepartmentMapper;
import az.parvin.hremployeeservice.myException.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentBusinessServiceImpl implements DepartmentBusinessService {

    private final DepartmentRepetitionChecker checker;
    private final DepartmentFunctionalService service;
    private final DepartmentMapper mapper;

    @Override
    public CommonResponse create(DepartmentRequest request) {
        checker.check(request.getDepartmentName());
        CommonResponse response = new CommonResponse();
        Department department = mapper.toEntity(request);
        response.setItem(mapper.toResponse(service.create(department)));
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
    public CommonResponse update(Long id, DepartmentRequest request) {
        checker.check(request.getDepartmentName());
        CommonResponse response = new CommonResponse();
        Department department = mapper.toEntity(request);
        response.setItem(mapper.toResponse(service.update(id, department)));
        return response;
    }
}
