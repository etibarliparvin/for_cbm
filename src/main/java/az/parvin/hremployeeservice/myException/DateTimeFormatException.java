package az.parvin.hremployeeservice.myException;

public class DateTimeFormatException extends BaseException {

    public DateTimeFormatException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }

    public DateTimeFormatException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(String.format(exceptionEnum.getMessage(), object), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}
