package my_little_monsters.handlers;

import my_little_monsters.error.ErrorMessage;
import my_little_monsters.error.NoDataFoundError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid (
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        return ResponseEntity.status(status).body("Data not valid");
    }

    @ExceptionHandler(NoDataFoundError.class)
    public ResponseEntity<ErrorMessage> handleNoDataFoundError(Exception exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorMessage.builder()
                        .status(404)
                        .error(exception.getMessage())
                        .build()
        );
    }
}
