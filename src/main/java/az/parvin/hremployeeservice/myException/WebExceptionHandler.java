package az.parvin.hremployeeservice.myException;

import az.parvin.hremployeeservice.myException.common.CommonMessage;
import az.parvin.hremployeeservice.myException.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ValidationException;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(BaseException.class)
    private ResponseEntity<?> handle(BaseException ex, WebRequest request) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus("Error");

        CommonMessage message = new CommonMessage();
        message.setMessage(ex.getMsg());
        message.setCode(ex.getCode());
        message.setDescription(ex.getDescription());

        commonResponse.setErrorMessage(message);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(commonResponse);
    }

    @ExceptionHandler(ValidationException.class)
    private ResponseEntity<?> validationHandler(ValidationException ex) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatus("Error");

        CommonMessage message = new CommonMessage();
        message.setMessage(ex.getMessage());
        message.setCode("500");
//        message.setDescription(ex.getCause().toString());

        commonResponse.setErrorMessage(message);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(commonResponse);
    }
}
