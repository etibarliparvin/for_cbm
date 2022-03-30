package az.parvin.hremployeeservice.validation.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface Email {

    String message() default "Email format is not valid! Please insert correct one";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
