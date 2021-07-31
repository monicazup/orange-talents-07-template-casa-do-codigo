package br.com.zupacademy.OT7.monica.casadocodigo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class CustomHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> manipulador(MethodArgumentNotValidException exception) {
        Collection<String> messages = new ArrayList<>();
        BindingResult bind = exception.getBindingResult();
        List<FieldError> errors = bind.getFieldErrors();
        errors.forEach(fieldError -> {
            String message = "Falha: valor de " + fieldError.getField() + " " + fieldError.getDefaultMessage();
            messages.add(message);

        });

        ErroPadronizado erroPadronizado = new ErroPadronizado(messages);
        return ResponseEntity.badRequest().body(erroPadronizado);

    }

}
