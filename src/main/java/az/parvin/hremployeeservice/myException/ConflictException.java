package az.parvin.hremployeeservice.myException;

public class ConflictException extends BaseException {

    public ConflictException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }

    public ConflictException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(String.format(exceptionEnum.getMessage(), object), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}
