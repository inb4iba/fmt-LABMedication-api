package fmt.labmedication.api.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDTO> handleInvalidRequest(MethodArgumentNotValidException exception) {
        ErrorMessageDTO response = getErrorResponse(exception);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessageDTO> handleDuplicateKey(DataIntegrityViolationException exception) {
        ErrorMessageDTO response = getErrorResponse(exception);
        return new ResponseEntity<>(response, null, 409);
    }

    private ErrorMessageDTO getErrorResponse(DataIntegrityViolationException exception) {
        if (exception.getCause() instanceof ConstraintViolationException) {
            String message = generateMessage((ConstraintViolationException) exception.getCause());
            return new ErrorMessageDTO(message);
        }
        return new ErrorMessageDTO("ERRO NÃO TRATADO!!!!!");
    }

    private ErrorMessageDTO getErrorResponse(MethodArgumentNotValidException exception) {
        String message = generateMessage(exception.getFieldErrors());
        return new ErrorMessageDTO(message);
    }

    private String generateMessage(ConstraintViolationException violation) {
        String field = violation.getConstraintName().split("_")[1];
        return field + " já registrado!";
    }

    private String generateMessage(List<FieldError> errors) {
        String message = errors.stream().map(e -> e.getField() + " " + e.getDefaultMessage())
                .collect(Collectors.joining(" | "));
        return message;
    }
}