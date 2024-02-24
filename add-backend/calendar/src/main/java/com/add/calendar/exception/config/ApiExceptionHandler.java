package com.add.calendar.exception.config;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = { ApiException.class })
  public ResponseEntity<ApiExceptionRequest> handleApiException(ApiException e) {

    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    ApiExceptionRequest apiException = new ApiExceptionRequest(e.getMessage(), e, badRequest,
        ZonedDateTime.now(ZoneId.of("Z")));

    log.error(e.getMessage());

    return new ResponseEntity<>(apiException, badRequest);

  }
}
