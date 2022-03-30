package az.parvin.hremployeeservice.exceptionApi;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ApiMessage implements Serializable {

    static final long serialVersionUID = -8827849321914598619L;
    ApiInfo apiInfo;
}
