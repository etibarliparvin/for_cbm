package az.parvin.hremployeeservice.exceptionApi;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class ApiError implements Serializable {

    static final long serialVersionUID = 6113485988637698820L;
    String message;
    String code;
    String description;
}
