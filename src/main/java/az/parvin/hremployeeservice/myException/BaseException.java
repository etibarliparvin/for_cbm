package az.parvin.hremployeeservice.myException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {

    String msg;
    String code;
    String description;
}
