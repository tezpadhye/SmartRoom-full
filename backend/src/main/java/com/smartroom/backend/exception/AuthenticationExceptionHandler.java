package com.smartroom.backend.exception;

import com.smartroom.backend.model.InvalidField;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AuthenticationExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException duplicateKeyException) {
        ApiError apiError = new ApiError(
                duplicateKeyException.getMessage(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleGenericException(RuntimeException runtimeException) {
        ApiError apiError = new ApiError(
                runtimeException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUserNameNotFoundException(UsernameNotFoundException usernameNotFoundException) {
        ApiError apiError = new ApiError(
                usernameNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException notValidException) {
        BindingResult result = notValidException.getBindingResult();
        List<FieldError> errorList = result.getFieldErrors();
        List<InvalidField> invalidFields = new ArrayList<>();

        getInvalidFields(errorList, invalidFields);

        NotValidError notValidError = new NotValidError(
                "Invalid input parameter",
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST,
                invalidFields
        );
        return new ResponseEntity<>(notValidError, HttpStatus.BAD_REQUEST);
    }

    private void getInvalidFields(List<FieldError> errorList, List<InvalidField> invalidFields) {

        for (int index = 0; index < errorList.size(); index++) {
            String fieldName = errorList.get(index).getField();
            String message = errorList.get(index).getDefaultMessage();

            invalidFields.add(new InvalidField(fieldName, message));
        }


    }


}
