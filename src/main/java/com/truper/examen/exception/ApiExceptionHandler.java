package com.truper.examen.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler( RecursoNoEncontradoExcepcion.class )
    public ResponseEntity< ApiException > handleObjectNotFoundException( RecursoNoEncontradoExcepcion exception, HttpServletRequest request ) {

        ApiException apiException = ApiException
                .builder()
                .timestamp( LocalDateTime.now() )
                .status( HttpStatus.NOT_FOUND.value() )
                .message( "Recurso no encontrado: " + exception.getMessage() )
                .details( request.getRequestURL().toString() )
                .build();

        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( apiException );

    }

    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity< ApiException > handleInvalidArguments(MethodArgumentNotValidException exception, HttpServletRequest request ) {

        Map< String, String > errors = new HashMap<>();

        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach( error -> {

                    String nameField = error.getField();
                    String errorMessage = error.getDefaultMessage();

                    errors.put( nameField, errorMessage );

                } );

        ApiException apiException = ApiException
                .builder()
                .timestamp( LocalDateTime.now() )
                .status( HttpStatus.BAD_REQUEST.value() )
                .message( "Se encontraron errores en los siguientes campos: " + errors )
                .details( request.getRequestURL().toString() )
                .build();

        log.error( "Descripción del error: " + apiException );

        return new ResponseEntity<>( apiException, HttpStatus.BAD_REQUEST );

    }

    /* @ExceptionHandler( Exception.class )
    public ResponseEntity< ApiException > handleGenericException( Exception exception, HttpServletRequest request ) {

        ApiException apiException = ApiException
                .builder()
                .timestamp( LocalDateTime.now() )
                .status( HttpStatus.INTERNAL_SERVER_ERROR.value() )
                .message( "Error interno del sistema: " + exception.getMessage() )
                .details( request.getRequestURL().toString() )
                .build();

        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( apiException );

    } */

}