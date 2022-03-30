package az.parvin.hremployeeservice.controller;

import az.parvin.hremployeeservice.dto.request.AddressRequest;
import az.parvin.hremployeeservice.service.address.AddressBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressBusinessService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AddressRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
