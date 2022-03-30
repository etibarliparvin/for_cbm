package az.parvin.hremployeeservice.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressRequest {

    String addressLine1;
    String addressLine2;
    String country;
    String city;
}
