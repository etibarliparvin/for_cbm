package az.parvin.hremployeeservice.controller;

import az.parvin.hremployeeservice.dto.request.JobDetailRequest;
import az.parvin.hremployeeservice.service.jobDetail.JobDetailBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobDetail")
@RequiredArgsConstructor
public class JobDetailController {

    private final JobDetailBusinessService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody JobDetailRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody JobDetailRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}
