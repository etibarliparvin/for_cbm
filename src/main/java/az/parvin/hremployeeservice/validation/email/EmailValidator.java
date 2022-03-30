package az.parvin.hremployeeservice.validation.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {

    public static final Pattern REGEX = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return check(value);
    }

    public static boolean check(String email) {
        Matcher matcher = REGEX.matcher(email);
        return matcher.find();
    }
}
