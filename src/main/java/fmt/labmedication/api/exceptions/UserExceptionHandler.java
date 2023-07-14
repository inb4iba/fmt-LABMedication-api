package fmt.labmedication.api.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessageDTO> handleDuplicateKey(DataIntegrityViolationException exception) {
        ErrorMessageDTO response = getUserConflictColumn(exception);
        return new ResponseEntity<>(response, null, 409);
    }

    private ErrorMessageDTO getUserConflictColumn(DataIntegrityViolationException exception) {
        if (exception.getCause() instanceof ConstraintViolationException) {
            String message = generateMessage((ConstraintViolationException) exception.getCause());
            return new ErrorMessageDTO(message);
        }
        return new ErrorMessageDTO("ERRO NÃO TRATADO!!!!!");
    }

    private String generateMessage(ConstraintViolationException violation) {
        String field = violation.getConstraintName().split("_")[1];
        return field + " já registrado!";
    }
}