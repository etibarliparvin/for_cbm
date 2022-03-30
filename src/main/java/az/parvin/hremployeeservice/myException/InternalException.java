package az.parvin.hremployeeservice.myException;

public class InternalException extends BaseException{

    public InternalException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }

    public InternalException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(String.format(exceptionEnum.getMessage(), object), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}
