package it.epicode.gestioneDispositivi.exceptions;

import it.epicode.gestioneDispositivi.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> BadRequestHandler(BadRequestException e){
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setErrorStatus(HttpStatus.BAD_REQUEST);
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DipendenteNotFoundException.class)
    public ResponseEntity<Object> DipendenteNotFoundHandler(DipendenteNotFoundException e){
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setErrorStatus(HttpStatus.NOT_FOUND);
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DispositivoNotFoundException.class)
    public ResponseEntity<Object> DispositivoNotFoundHandler(DispositivoNotFoundException e){
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setErrorStatus(HttpStatus.NOT_FOUND);
        error.setErrorTime(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
