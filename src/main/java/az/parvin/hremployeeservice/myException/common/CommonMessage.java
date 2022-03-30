package az.parvin.hremployeeservice.myException.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonMessage {

    String message;
    String code;
    String description;
}
