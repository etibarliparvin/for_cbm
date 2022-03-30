package az.parvin.hremployeeservice.myException.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonResponse {

    Long time = System.currentTimeMillis();
    String status = "Success";
    Object item;
    CommonMessage errorMessage;
}
