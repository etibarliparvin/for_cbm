package az.parvin.hremployeeservice.exceptionApi;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ApiInfo implements Serializable {

    static final long serialVersionUID = 192565544055788114L;
    Boolean success;
    String status;
    String requestId;
    String responseId;
    String timestamp;
    Collection<ApiError> errors;
}
