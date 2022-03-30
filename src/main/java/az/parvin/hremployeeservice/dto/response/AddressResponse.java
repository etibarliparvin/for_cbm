package az.parvin.hremployeeservice.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressResponse {

    Long id;
    String addressLine1;
    String addressLine2;
    String country;
    String city;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;
}
